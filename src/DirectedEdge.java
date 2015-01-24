/**
 * Subclass of Edge for specifying directed edge
 * @author edwardliu
 *
 * @param <E> generic element
 */
public class DirectedEdge<E> extends Edge<E> {

	Vertex<E> source;
	Vertex<E> target;
	
	public DirectedEdge(Vertex<E> v1, Vertex<E> v2) {
		super(v1, v2);
		source = v1;
		target = v2;
	}
	
	public Vertex<E> getSource(){
		return source;
	}
	
	public Vertex<E> getTarget(){
		return target;
	}
	
	public void switchDirection(){
		Vertex<E> temp = source;
		source = target;
		target = temp;
	}
	
}
