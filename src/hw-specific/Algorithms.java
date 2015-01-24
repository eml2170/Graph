import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Algorithms {
	
	/**
	 * Returns strongly connected components of G
	 */
	public static List<TreeSet<Vertex<Integer>>> findSCCs(MyGraph g){
		//Run DFS on G
		dfs(g, g.vertexSet);
		
		//Reverse graph
		g.reverseGraph();
		
			//Construct vertex set ordered by decreasing finish times
			Set<Vertex<Integer>> verticesByDecFinishTimes = new TreeSet<Vertex<Integer>>(new FinishTimeComparator());
			verticesByDecFinishTimes.addAll(g.vertexSet);
		
		//Run DFS on G in order of decreasing finish times
		return dfs(g, verticesByDecFinishTimes);
	}
	
	/**
	 * @param g Graph
	 * @param vertexSet vertices to dfs on
	 * @return forest of connected components
	 */
	public static List<TreeSet<Vertex<Integer>>> dfs(MyGraph g, Set<Vertex<Integer>> vertexSet){
		//init
		Time t = new Time();
		int n = g.vertexSet.size();
		boolean[] explored = new boolean[n];
		for(Vertex<Integer> v : g.vertexSet){
			explored[v.element-1] = false;
		}
		List<TreeSet<Vertex<Integer>>> connectedComponents = new LinkedList<TreeSet<Vertex<Integer>>>();
		
		//recursively search new neighbors
		for(Vertex<Integer> v : vertexSet){
			if(explored[v.element-1] == false){
				TreeSet<Vertex<Integer>> connectedComponent = 
						new TreeSet<Vertex<Integer>>(new IndexComparator());
				g = search(g, v, explored, t, connectedComponent);
				connectedComponents.add(connectedComponent);
			}
		}
		return connectedComponents;
	}
	
	private static MyGraph search(MyGraph g, Vertex<Integer> u, boolean[] explored, Time t, TreeSet<Vertex<Integer>> cc){
		previsit(u, t);
		cc.add(u);
		explored[u.element-1] = true;
		List<Vertex<Integer>> neighbors = g.getNeighbors(u);
		for(Vertex<Integer> v : neighbors){
			if(explored[v.element-1] == false)
				g = search(g, v, explored, t, cc);
		}
		postvisit(u, t);
		return g;
	}
	
	private static void previsit(Vertex<Integer> v, Time t){
		v.start = t.time;
		t.time++;
	}
	
	private static void postvisit(Vertex<Integer> v, Time t){
		v.finish = t.time;
		t.time++;
	}
}

class Time{
	int time;
	
	public Time(){
		time = 1;
	}
}

class FinishTimeComparator implements Comparator<Vertex<Integer>>{
	//allows sorting by decreasing finish times
	public int compare(Vertex<Integer> v1, Vertex<Integer> v2) {
		Integer finish1 = v1.finish;
		Integer finish2 = v2.finish;
		return finish2.compareTo(finish1);
	}
}

class IndexComparator implements Comparator<Vertex<Integer>>{
	//allows sorting by decreasing finish times
	public int compare(Vertex<Integer> v1, Vertex<Integer> v2) {
		return v1.element.compareTo(v2.element);
	}
}