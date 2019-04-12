package Graph;

public class Edge<T> {

	GraphNode<T> start;
	GraphNode<T> end; 
	int weight; 
	
	public Edge(GraphNode<T> s, GraphNode<T> e) {
		this.start = s; 
		this.end = e; 
	}
	
	public Edge(GraphNode<T> s, GraphNode<T> e, int weight) {
		this.start = s; 
		this.end = e; 
		this.weight = weight; 
	}
	
}
