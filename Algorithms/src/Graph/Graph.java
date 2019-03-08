package Graph;

public class Graph {
	
	public GraphNode[] nodes; 
	public int numNodes; 
	public int size;
	public int[][] adjMatrix; 
	
	public Graph(int size) {
		nodes = new GraphNode[size]; 
		this.size = size; 
		this.numNodes = 0; 
		adjMatrix = new int[size][size]; 
		initMatrix(this.size); 
	}
	
	private void initMatrix(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				adjMatrix[i][j] = 0; 
			}
		}
	}
	
	public void addNode(String data) {
		if (numNodes == size) {
			return;
		}
		GraphNode newNode = new GraphNode(data); 
		nodes[numNodes] = newNode; 
		numNodes += 1; 
	}
	
	public void addEdge(String dataOne, String dataTwo) {
		
		int indexOne = getIndex(dataOne); 
		int indexTwo = getIndex(dataTwo); 
		if (indexOne == -1 || indexTwo == -1) {
			return; 
		} else {
			adjMatrix[indexOne][indexTwo] = 1; 
			
			//if graph is undirected uncomment next line
			//adjMatrix[indexTwo][indexOne]; 
		}
		
	}
	
	public int getIndex(String val) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].data == val) {
				return i; 
			}
		}
		return -1; 
	}
	
	public void increaseSize(int newSize) {
		if (newSize < this.size) {
			return; 
		} 
		GraphNode[] newNodes = new GraphNode[newSize]; 
		for (int i = 0; i < nodes.length; i++) {
			newNodes[i] = nodes[i]; 
		}
		
		int[][] newAdjMatrix = new int[newSize][newSize]; 
		
		for (int i = 0; i < newSize; i++) {
			for (int j = 0; j < newSize; j++) {
				newAdjMatrix[i][j] = 0; 
			}
		}
		
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; i < this.size; j++) {
				newAdjMatrix[i][j] = adjMatrix[i][j]; 
			}
		}
		this.size = newSize; 
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Graph(5);
		g.addNode("Matt");
		g.addNode("Elise");
		g.addNode("One");
		g.addNode("Two");
		g.addNode("Three");
		g.addNode("test");
		g.addEdge("Matt", "Elise");
		g.addEdge("Elise", "Matt");
		g.addEdge("Matt", "Three");
		g.addEdge("Elise", "One");
		g.addEdge("One", "Two");
		for (int i = 0; i < g.numNodes; i++) {
			g.nodes[i].visited = false; 
		}
		System.out.println(DFS.DepthFirstSearch(g, "Matt", "Two")); 

	}

}
