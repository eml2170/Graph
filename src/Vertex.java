/**
 * Parameterized Vertex class
 * @author edwardliu
 *
 * @param <E> element
 */
public class Vertex<E> {

	E element;
	int start;
	int finish;
	
	public Vertex(E element){
		this.element = element;
		start = 0;
		finish = 0;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex<?> other = (Vertex<?>) obj;
        if (element == null) {
            if (other.element != null)
                return false;
        } else if (!element.equals(other.element))
            return false;
        return true;
    }
	
	@Override
	public String toString() {
		return element.toString();
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((element == null) ? 0 : element.hashCode());
		return result;
	}
	
}
