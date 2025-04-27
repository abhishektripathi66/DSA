package Graph;

import java.util.*;
import java.util.Queue;

public class GraphExample {
    private int vertices; 
    private LinkedList<Integer> [] adjList;

    // Constructor
    public GraphExample(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add an edge
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); // for undirected graph
    }

    // BFS Traversal
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for(int adj : adjList[vertex]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    // DFS traversal
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        dfsHelper(startVertex, visited);
    }

    // helper function for DFS
    public void dfsHelper(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adj : adjList[vertex]) {
            if (!visited[adj]) {
                dfsHelper(adj, visited);
            }
        }
    }

    // Main Method to test
    public static void main(String[] args) {
        GraphExample graph = new GraphExample(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("BFS Traversal starting from node 0:");
        graph.bfs(0);

        System.out.println("\nDFS Traversal starting from node 0:");
        graph.dfs(0);

    }
}
