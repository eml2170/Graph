/**
 * Class which handles the output format specified by homework
 * @author edwardliu
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;


public class Output {

	List<TreeSet<Vertex<Integer>>> sccs;

	//number of sccs
	int k;
	
	String[] output;
	
	public Output(List<TreeSet<Vertex<Integer>>> sccs){
		this.sccs = sccs;
		formOutput();
	}
	
	/**
	 * Sort sccs in increasing order of index of first node.
	 * Note that WITHIN each scc, nodes are already sorted in increasing order.
	 */
	public void formOutput(){
		k = sccs.size();
		output = new String[k+1];
		Collections.sort(sccs, new SccComparator());
		output[0] = "" + k;
		for(int i = 1; i < output.length; i++){
			TreeSet<Vertex<Integer>> scc = sccs.get(i-1);
			int p = scc.size();
			StringBuffer line = new StringBuffer();
			line.append(p);
			for(int j = 0; j < p; j++){
				line.append(" " + scc.pollFirst());
			}
			output[i] = line.toString();
		}
	}
	
	public void write(String filename) throws IOException{
		FileWriter filewriter = new FileWriter(new File(filename));
		String newline = "\n";
		for(int i = 0; i < output.length; i++){
			filewriter.write(output[i] + newline);
		}
		filewriter.close();
	}
}

class SccComparator implements Comparator<TreeSet<Vertex<Integer>>>{

	@Override
	public int compare(TreeSet<Vertex<Integer>> scc1, TreeSet<Vertex<Integer>> scc2) {
		return scc1.first().element.compareTo(scc2.first().element);
	}

	
}