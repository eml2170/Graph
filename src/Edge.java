/**
 * Parameterized Edge
 * @author edwardliu
 *
 * @param <E> element
 */
public class Edge<E> {

	Vertex<E> v1;
	Vertex<E> v2;
	
	public Edge(Vertex<E> v1, Vertex<E> v2){
		this.v1 = v1;
		this.v2 = v2;
	}
	
	public Vertex<E> getOtherVertex(Vertex<E> v){
		if(v.equals(v1))
			return v2;
		else return v1;
	}
	
	public String toString(){
		return "(" + v1 + "," + v2 + ")";
	}
	
}
