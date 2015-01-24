/**
 * Interface which enforces that all implementing types
 * allows to addVertex and addEdge
 * @author edwardliu
 *
 * @param <E>
 */
public interface Graph<E> {

	public void addVertex(Vertex<E> v);
	public Edge<E> addEdge(Vertex<E> source, Vertex<E> target);
	
}
