import java.util.*;

public class DepthFirstSearch {

    // Adjacency list for the graph
    private List<List<Integer>> adjList;

    // Constructor to initialize the adjacency list
    public DepthFirstSearch(int numVertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
        adjList.get(w).add(v); // For directed graphs, remove this line
    }

    // DFS traversal from a given starting node
    public void dfs(int start) {
        boolean[] visited = new boolean[adjList.size()];
        dfsUtil(start, visited);
    }

    // Utility method for recursive DFS
    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adj : adjList.get(vertex)) {
            if (!visited[adj]) {
                dfsUtil(adj, visited);
            }
        }
    }

    // Main method to demonstrate DFS
    public static void main(String[] args) {
        DepthFirstSearch graph = new DepthFirstSearch(6);

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        // Perform DFS starting from vertex 0
        System.out.println("Depth First Search starting from vertex 0:");
        graph.dfs(0);
    }
}
