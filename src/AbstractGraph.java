/**
 * Abstract class with functionality common to directed graphs and undirected graphs.
 * @author edwardliu
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public abstract class AbstractGraph<E> implements Graph<E> {

	Set<Vertex<E>> vertexSet;
	Set<Edge<E>> edgeSet;
	Map<Vertex<E>, List<Vertex<E>>> adjacencyList;
	
	public AbstractGraph(){
		vertexSet = new HashSet<Vertex<E>>();
		edgeSet = new HashSet<Edge<E>>();
		adjacencyList = new HashMap<Vertex<E>, List<Vertex<E>>>();
	}
	
	/**
	 * Adds new vertex to the graph.
	 */
	public void addVertex(Vertex<E> v){
		vertexSet.add(v);
		adjacencyList.put(v, new LinkedList<Vertex<E>>());
	}
	
	/**
	 * Gets the neighbors of a vertex.
	 */
	public List<Vertex<E>> getNeighbors(Vertex<E> v){
		return adjacencyList.get(v);
	}
	
	/**
	 * Adds new vertices to the graph.
	 */
	protected void updateGraphVertices(Set<Vertex<E>> vertices){
		for(Vertex<E> v : vertices){
			if(!vertexSet.contains(v)){
				vertexSet.add(v);
				adjacencyList.put(v, new LinkedList<Vertex<E>>());
			}
		}
	}
	
	/**
	 * Returns String summary of the graph.
	 */
	public String toString(){
		StringBuffer stringBuffer = new StringBuffer();
		String newLine = "\n";
		stringBuffer.append("V=" + vertexSet.toString() + newLine);
		stringBuffer.append("n=" + vertexSet.size() + newLine);
		stringBuffer.append("E=" + edgeSet.toString() + newLine);
		stringBuffer.append("m=" + edgeSet.size() + newLine);
		stringBuffer.append("adjacency list=" + adjacencyList.toString());
		return stringBuffer.toString();
	}
	
}
