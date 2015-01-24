/**
 * Custom digraph I wrote for the homework.
 * @author edwardliu
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class MyGraph extends DirectedGraph<Integer> {

	ArrayList<Vertex<Integer>> vertexArray;
	
	public MyGraph(String filename) throws FileNotFoundException{
		int n = getNFromFile(filename);
		populateVertices(n);
		initAdjacencyList(n);
		createEdgesFromFile(filename);
	}
	
	/**
	 * Simply extracts n, the size of the vertex set
	 */
	private int getNFromFile(String filename) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(filename));
		String line = scanner.nextLine();
		String[] metaData = line.split(" ");
		scanner.close();
		return Integer.parseInt(metaData[0]);
	}
	
	/**
	 * Initiates vertex arraylist, treating the vertices' elements as indices.
	 * @param n
	 */
	public void populateVertices(int n){
		vertexArray = new ArrayList<Vertex<Integer>>(n);
		for(int i = 0; i < n; i++){
			Vertex<Integer> v = new Vertex<Integer>(new Integer(i+1));
			vertexArray.add(i, v);
			vertexSet.add(v);
		}
	}
	
	/**
	 * Initializes adjacency list
	 */
	public void initAdjacencyList(int n){
		for(int i = 0; i < n; i++){
			adjacencyList.put(vertexArray.get(i), new LinkedList<Vertex<Integer>>());
		}
	}
	
	/**
	 * Builds the digraph from the input file.
	 */
	private void createEdgesFromFile(String filename) throws FileNotFoundException{
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		
		//Skip first line with metadata
		scanner.nextLine();
		
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			String[] vertices = line.split(" ");
			
			Vertex<Integer> source = vertexArray.get(Integer.parseInt(vertices[0])-1);
			Vertex<Integer> target = vertexArray.get(Integer.parseInt(vertices[1])-1);
			
			addEdge(source, target);
		}
		
		scanner.close();
	}
	
}
