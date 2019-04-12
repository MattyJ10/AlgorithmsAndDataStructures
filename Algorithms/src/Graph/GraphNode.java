package Graph;

import java.util.ArrayList;

public class GraphNode<T> {

	public T data;
	public boolean visited; 
	public ArrayList<GraphNode<T>> neighbors; 
	
	GraphNode(T data) {
		this.data = data; 
		this.visited = false; 
		this.neighbors = new ArrayList<GraphNode<T>>(); 
	}
	
	GraphNode(GraphNode<T> g) {
		this.data = g.data; 
		this.visited = false; 
		this.neighbors = new ArrayList<GraphNode<T>>();
	}
	
	public void addEdge(GraphNode<T> e) {
		this.neighbors.add(e); 
	}
	
	public void removeEdge(GraphNode<T> e) {
		this.neighbors.remove(e);
	}
	
}
