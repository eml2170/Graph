/**
 * Algorithms for Data Science
 * Fall 2014
 * 
 * Assignment 2
 * Implementation of algorithm for finding strongly connected components
 * @author edwardliu (eml2170)
 */
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		if(args[0].equals("all")){
			//Run over all files. What I used to generate my output.
			for(int i = 0; i < 20; i++){
				String id = "";
				if(i<10)
					id += "0";
				id += i;
				String inputFile = "InputGraphs/in" + id + ".txt";
				String outputFile = "OutputGraphs/out" + id + ".txt";
				run(inputFile, outputFile);
			}
		}
		else{
			//Run on the input filename and write output file with same id number
			String inputFile = "InputGraphs/" + args[0];
			System.out.println(inputFile);
			String outputFile = "OutputGraphs/out" + args[0].substring(2);
			System.out.println(outputFile);
			run(inputFile, outputFile);
		}
	}
	
	private static void run(String inputFile, String outputFile){
		try{
			MyGraph g = new MyGraph(inputFile);
			new Output(Algorithms.findSCCs(g)).write(outputFile);
		}
		catch(IOException e){
			System.out.println("IO error");
		}
	}
}
