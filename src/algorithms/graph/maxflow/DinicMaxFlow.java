package algorithms.graph.maxflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Dinic's Algorithm for Maximum Flow in a Graph
 * 
 * Dinic's algorithm computes the maximum flow in a flow network. 
 * It is more efficient than Ford-Fulkerson because it uses level graphs and blocking flows.
 * 
 * The algorithm works by:
 * 1. Building a "level graph" using BFS (ignoring edges that are full).
 * 2. Finding augmenting paths in the level graph using DFS (blocking flow).
 * 
 * Time Complexity:
 *   - General Networks: O(V^2 * E)
 *   - Bipartite Matching: O(E * sqrt(V))
 * 
 * Space Complexity:
 *   - O(V + E) for the adjacency list and auxiliary arrays (level, ptr)
 * 
 * Example:
 *   Input Graph (Source: 0, Sink: 5):
 *     0 -> 1 (cap 10), 0 -> 2 (cap 10)
 *     1 -> 3 (cap 4), 1 -> 4 (cap 8), 1 -> 2 (cap 2)
 *     2 -> 4 (cap 9)
 *     3 -> 5 (cap 10)
 *     4 -> 3 (cap 6), 4 -> 5 (cap 10)
 *
 *   Output:
 *     Maximum Flow: 19
 */
public class DinicMaxFlow {

    // Edge class to store flow and capacity
    static class Edge {
        int to;
        int capacity;
        int flow;
        int rev; // index of the reverse edge

        Edge(int to, int capacity, int rev) {
            this.to = to;
            this.capacity = capacity;
            this.rev = rev;
            this.flow = 0;
        }
    }

    private int n;
    private ArrayList<ArrayList<Edge>> adj;
    private int[] level;

    public DinicMaxFlow(int n) {
        this.n = n;
        this.adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Edge>());
        }
        this.level = new int[n];
    }

    // Adds a directed edge to the graph
    public void addEdge(int from, int to, int capacity) {
        // Forward edge
        adj.get(from).add(new Edge(to, capacity, adj.get(to).size()));
        // Backward edge with 0 capacity
        adj.get(to).add(new Edge(from, 0, adj.get(from).size() - 1));
    }

    // Builds the level graph using BFS
    private boolean bfs(int s, int t) {
        Arrays.fill(level, -1);
        level[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (Edge edge : adj.get(u)) {
                // If capacity is remaining and node is not visited
                if (edge.capacity - edge.flow > 0 && level[edge.to] == -1) {
                    level[edge.to] = level[u] + 1;
                    q.add(edge.to);
                }
            }
        }
        // Return true if sink is reachable
        return level[t] != -1;
    }

    // Finds augmenting paths in the level graph using DFS
    private int dfs(int u, int t, int flow, int[] ptr) {
        if (u == t || flow == 0)
            return flow;

        for (int i = ptr[u]; i < adj.get(u).size(); i++) {
            ptr[u] = i;
            Edge edge = adj.get(u).get(i);

            // If the next node is in the next level and has capacity
            if (level[u] + 1 == level[edge.to] && edge.capacity - edge.flow > 0) {
                int pushed = dfs(edge.to, t, Math.min(flow, edge.capacity - edge.flow), ptr);
                if (pushed > 0) {
                    edge.flow += pushed;
                    adj.get(edge.to).get(edge.rev).flow -= pushed;
                    return pushed;
                }
            }
        }
        return 0;
    }

    // Computes the maximum flow from source s to sink t
    public int maxFlow(int s, int t) {
        int maxFlow = 0;
        // Keep repeating while there is a path in the level graph
        while (bfs(s, t)) {
            int[] ptr = new int[n]; // pointer to track edges searched in DFS
            while (true) {
                int pushed = dfs(s, t, Integer.MAX_VALUE, ptr);
                if (pushed == 0)
                    break;
                maxFlow += pushed;
            }
        }
        return maxFlow;
    }

    // Helper method to convert an adjacency matrix into the Dinic's graph structure
    private static DinicMaxFlow convertGridToGraph(int[][] grid) {
        int n = grid.length;
        DinicMaxFlow dinic = new DinicMaxFlow(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    dinic.addEdge(i, j, grid[i][j]);
                }
            }
        }
        return dinic;
    }

    public static void main(String[] args) {
        // Representation of the graph as an adjacency matrix
        // 0: Source, 5: Sink
        int[][] grid = {
                { 0, 10, 10, 0, 0, 0 }, // 0
                { 0, 0, 2, 4, 8, 0 }, // 1
                { 0, 0, 0, 0, 9, 0 }, // 2
                { 0, 0, 0, 0, 0, 10 }, // 3
                { 0, 0, 0, 6, 0, 10 }, // 4
                { 0, 0, 0, 0, 0, 0 } // 5
        };

        int source = 0;
        int sink = 5;

        // Convert the grid and compute max flow
        DinicMaxFlow dinic = convertGridToGraph(grid);
        int result = dinic.maxFlow(source, sink);

        System.out.println("Maximum Flow from " + source + " to " + sink + " is: " + result);

        // Expected result: 19
        if (result == 19) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed! Expected 19, got " + result);
        }
    }
}
