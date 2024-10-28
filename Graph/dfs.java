import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Integer, List<Integer>> adjList;

    // Constructor to initialize the graph
    public Graph() {
        adjList = new HashMap<>();
    }

    // Method to add an edge between two nodes (directed graph)
    public void addEdge(int source, int destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.get(source).add(destination);
    }

    // DFS utility function
    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " "); // Print the vertex as part of DFS traversal

        // Visit all neighbors of the current vertex
        List<Integer> neighbors = adjList.get(vertex);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    dfsUtil(neighbor, visited);
                }
            }
        }
    }

    // DFS traversal function
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[adjList.size()];
        System.out.println("DFS Traversal starting from vertex " + startVertex + ":");
        dfsUtil(startVertex, visited);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        
        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        // Perform DFS starting from vertex 2
        graph.dfs(2);
    }
}
