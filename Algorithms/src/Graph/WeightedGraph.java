package Graph;
import java.util.ArrayList;

public class WeightedGraph {
	
	public class WeightedGraphNode {
		
		int data; 
		ArrayList<Edge> edges = new ArrayList<Edge>();
		boolean visited; 
		
		WeightedGraphNode(int data) {
			this.data = data; 
			this.visited = false; 
			
		}
		
	}
	
	public class Edge {
		
		int weight; 
		WeightedGraphNode start;
		WeightedGraphNode end; 
		
		public Edge(int weight, WeightedGraphNode start, WeightedGraphNode end) {
			this.weight = weight; 
			this.start = start;
			this.end = end; 
		}
		
	}
	
	public class ValueAndPrev {
		
		int pathLength;
		WeightedGraphNode prevNode; 
		
		
		ValueAndPrev(int length, WeightedGraphNode prev) {
			this.pathLength = length; 
			this.prevNode = prev;
		}
		
	}
	
	ValueAndPrev[] shortestPathsFromStart; 
	WeightedGraphNode[] nodes; 
	int size; 
	int startIndex; 
	
	public WeightedGraph(int size) {
		this.nodes = new WeightedGraphNode[size]; 
		this.size = 0;
		this.shortestPathsFromStart = new ValueAndPrev[size]; 
		for (int i = 0; i < this.shortestPathsFromStart.length; i++) {
			this.shortestPathsFromStart[i] = new ValueAndPrev(Integer.MAX_VALUE, null);  
		}
	}
	
	public void addNode(int value) {
		if (size >= nodes.length) {
			System.out.println("no space in graph"); 
			return;
		}
		this.nodes[size] = new WeightedGraphNode(value); 
		size++; 
	}
	
	public void addEdge(int start, int end, int weight) {
		int startIndex = findIndex(start); 
		int endIndex = findIndex(end); 
		if (startIndex != -1 && endIndex != -1) {
			Edge e1 = new Edge(weight, nodes[startIndex], nodes[endIndex]);
			Edge e2 = new Edge(weight, nodes[endIndex], nodes[startIndex]); 
			nodes[startIndex].edges.add(e1); 
			nodes[endIndex].edges.add(e2); 
		} else {
			System.out.println("Could not add edge, one of the values doesn't exist"); 
		}
	}
	
	public int findIndex(int value) {
		for (int i = 0; i < size; i++) {
			if (nodes[i].data == value) {
				return i; 
			}
		}
		return -1; 
	}
	
	public void dijkstras(int start) {
		this.startIndex = findIndex(start); 
		if (this.startIndex != -1) {
			//initialize all nodes to unvisited
			for (int i = 0; i < this.nodes.length; i++) {
				this.nodes[i].visited = false; 
			}
			//initialize starting values for start node
			this.shortestPathsFromStart[startIndex].pathLength = 0; 
			this.shortestPathsFromStart[startIndex].prevNode = this.nodes[startIndex]; 
			//visit the starting node
			this.nodes[startIndex].visited = true;
			//Loop through all neighbors of the start node
			for (int i = 0; i < nodes[startIndex].edges.size(); i++) {
				//determine the weight from start to neighbor
				Edge e = this.nodes[startIndex].edges.get(i); 
				int endIndex = findIndex(e.end.data);
				int w = e.weight + this.shortestPathsFromStart[startIndex].pathLength; 
				//update the table if necessary
				if (w < this.shortestPathsFromStart[endIndex].pathLength) {
					this.shortestPathsFromStart[endIndex].pathLength = w; 
					this.shortestPathsFromStart[endIndex].prevNode = nodes[startIndex]; 
				}
			} 
			while(true) {
				//determine next node based on smallest available value
				int nextNode = determineNextNode(); 
				//no unvisited nodes found so break from the loop and you're done
				if (nextNode == -1) {
					break;
				}
				//visit node
				this.nodes[nextNode].visited = true; 
				//loop through each nodes neighbors and update the table if necessary
				for (int i = 0; i < nodes[nextNode].edges.size(); i++) {
					Edge e = this.nodes[nextNode].edges.get(i); 
					int endIndex = findIndex(e.end.data); 
					if (nodes[endIndex].visited) {
						continue; 
					}
					int w = e.weight + this.shortestPathsFromStart[nextNode].pathLength; 
					if (w < this.shortestPathsFromStart[endIndex].pathLength) {
						this.shortestPathsFromStart[endIndex].pathLength = w; 
						this.shortestPathsFromStart[endIndex].prevNode = nodes[nextNode]; 
					}
				}
			}
		}
	}
	
	public void printShortestPathTable() {
		for (int i = 0; i < this.shortestPathsFromStart.length; i++) {
			System.out.println("path length to " + i + ": " + this.shortestPathsFromStart[i].pathLength); 
		}
	}
	
	public int determineNextNode() {
		//returns the next unvisited node with the smallest path so far
		int min = Integer.MAX_VALUE; 
		int ret = -1; 
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].visited == false && this.shortestPathsFromStart[i].pathLength < min) {
				ret = i;
				min = this.shortestPathsFromStart[i].pathLength;
			}
		}
		return ret; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeightedGraph g = new WeightedGraph(4); 
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 5);
		g.addEdge(2, 3, 2);
		g.addEdge(3, 4, 4);
		g.dijkstras(1);
		g.printShortestPathTable();
	}

}
