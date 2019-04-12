package Graph;

import java.util.LinkedList;

public class BFS {
	
	public static boolean breadthFirstSearch(Graph g, String start, String end) {
		
		int startIndex = g.getIndex(start); 
		int endIndex = g.getIndex(end); 
		
		//make sure both strings are in the graph
		if (startIndex == -1 || endIndex == -1) {
			return false; 
		}
		
		GraphNode startNode = g.nodes[startIndex]; 
		
		//LinkedList acting as a Queue
		LinkedList<GraphNode> q = new LinkedList<GraphNode>(); 
		
		//set each node to unvisited
		for (int i = 0; i < g.numNodes; i++) {
			g.nodes[i].visited = false; 
		}
		
		//start at first node, mark as visited and add to queue
		startNode.visited = true; 
		q.add(startNode);
		GraphNode current; 
		int currentIndex; 
		
		while(!q.isEmpty()) {
			current = q.removeFirst();
			System.out.println(current.data); 
			currentIndex = g.getIndex(current.data); 
			for (int i = 0; i < g.size; i++) {
				if (g.adjMatrix[currentIndex][i] == 1) {
					if (!g.nodes[i].visited){
						if (g.nodes[i].data == end) {
							return true; 
						} else {
							g.nodes[i].visited = true; 
							q.add(g.nodes[i]); 
						}
					}
				}
			}
		}
		return false; 
	}

}
