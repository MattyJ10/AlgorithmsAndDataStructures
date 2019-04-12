package Graph;

public class DFS {

	public static boolean DepthFirstSearch(Graph g, String start, String end) {
		
		int startIndex = g.getIndex(start); 
		int endIndex = g.getIndex(end); 
		if (startIndex == -1 || endIndex == -1) {
			return false; 
		}
		System.out.println(start); 
		if (start == end) {
			return true; 
		}
		GraphNode startNode = g.nodes[startIndex];
		startNode.visited = true; 
		for (int i = 0; i < g.size; i++) {
			if (g.adjMatrix[startIndex][i] == 1) {
				//there's an edge here so DFS at this node if not visited
				if (!g.nodes[i].visited)
					return DepthFirstSearch(g, g.nodes[i].data, end);
			}
		}
		return false; 
	}
	
}
