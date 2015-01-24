/**
 * Subclass of AbstractGraph for digraphs
 * @author edwardliu
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class DirectedGraph<E> extends AbstractGraph<E> {
	
	public void addEdge(DirectedEdge<E> edge){
		edgeSet.add(edge);
		getNeighbors(edge.getSource()).add(edge.getTarget());
	}
	
	public DirectedEdge<E> addEdge(Vertex<E> source, Vertex<E> target){
		DirectedEdge<E> edge = new DirectedEdge<E>(source, target);
		
		Set<Vertex<E>> edgeVertices = new HashSet<Vertex<E>>();
		edgeVertices.add(source);
		edgeVertices.add(target);
		updateGraphVertices(edgeVertices);
		
		addEdge(edge);
		return edge;
	}
	
	public void reverseGraph(){
		//refresh adjacency list
		adjacencyList = new HashMap<Vertex<E>, List<Vertex<E>>>();
		for(Vertex<E> v : vertexSet){
			adjacencyList.put(v, new LinkedList<Vertex<E>>());
		}
		
		//update directions and repopulate adjacency list
		for(Edge<E> edge : edgeSet){
			DirectedEdge<E> directedEdge = (DirectedEdge<E>) edge;
			directedEdge.switchDirection();
			getNeighbors(directedEdge.getSource()).add(directedEdge.getTarget());
		}		
		
	}
	
}
