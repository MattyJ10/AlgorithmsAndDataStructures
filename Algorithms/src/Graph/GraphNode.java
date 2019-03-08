package Graph;

public class GraphNode {

	public String data; 
	public int intData; 
	public boolean visited; 
	
	GraphNode(String data) {
		this.data = data; 
		this.visited = false; 
	}
	
	GraphNode(GraphNode g) {
		this.data = g.data; 
		this.visited = g.visited; 
	}
	
	GraphNode(int data) {
		this.intData = data; 
		this.visited = false; 
	}
	
}
