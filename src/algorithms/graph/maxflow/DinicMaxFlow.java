package algorithms.graph.maxflow;

import java.util.*;

/*
 * Dinic's Algorithm for Maximum Flow in a Graph
 * 
 * Dinic's algorithm is a strongly polynomial algorithm for computing the maximum flow in a flow network. 
 * It runs in O(V^2 * E) time in general networks and O(E * sqrt(V)) in bipartite matching networks.
 * 
 * The algorithm works by repeatedly:
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

    private static class Edge {
        int to;
        long capacity;
        long flow;
        int rev; // index of the reverse edge in the adjacency list of 'to'

        Edge(int to, long capacity, int rev) {
            this.to = to;
            this.capacity = capacity;
            this.rev = rev;
            this.flow = 0;
        }

        public long remainingCapacity() {
            return capacity - flow;
        }
    }

    private final int n;
    private final List<Edge>[] adj;
    private final int[] level;

    @SuppressWarnings("unchecked")
    public DinicMaxFlow(int n) {
        this.n = n;
        this.adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        this.level = new int[n];
    }

    // Adds a directed edge to the graph
    public void addEdge(int from, int to, long capacity) {
        adj[from].add(new Edge(to, capacity, adj[to].size()));
        adj[to].add(new Edge(from, 0, adj[from].size() - 1));
    }

    // Builds the level graph using BFS
    private boolean bfs(int s, int t) {
        Arrays.fill(level, -1);
        level[s] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Edge edge : adj[u]) {
                if (edge.remainingCapacity() > 0 && level[edge.to] == -1) {
                    level[edge.to] = level[u] + 1;
                    queue.add(edge.to);
                }
            }
        }
        return level[t] != -1;
    }

    // Finds augmenting paths in the level graph using DFS
    private long dfs(int u, int t, long flow, int[] ptr) {
        if (u == t || flow == 0)
            return flow;

        for (; ptr[u] < adj[u].size(); ptr[u]++) {
            Edge edge = adj[u].get(ptr[u]);
            if (level[u] + 1 != level[edge.to] || edge.remainingCapacity() == 0)
                continue;

            long pushed = dfs(edge.to, t, Math.min(flow, edge.remainingCapacity()), ptr);
            if (pushed > 0) {
                edge.flow += pushed;
                adj[edge.to].get(edge.rev).flow -= pushed;
                return pushed;
            }
        }
        return 0;
    }

    // Computes the maximum flow from source s to sink t
    public long maxFlow(int s, int t) {
        long maxFlow = 0;
        while (bfs(s, t)) {
            int[] ptr = new int[n];
            while (true) {
                long pushed = dfs(s, t, Long.MAX_VALUE, ptr);
                if (pushed == 0)
                    break;
                maxFlow += pushed;
            }
        }
        return maxFlow;
    }

    public static void main(String[] args) {
        // Example Graph:
        // Source: 0, Sink: 5
        // 0 -> 1 (cap 10), 0 -> 2 (cap 10)
        // 1 -> 3 (cap 4), 1 -> 4 (cap 8), 1 -> 2 (cap 2)
        // 2 -> 4 (cap 9)
        // 3 -> 5 (cap 10)
        // 4 -> 3 (cap 6), 4 -> 5 (cap 10)

        int n = 6;
        int source = 0;
        int sink = 5;

        DinicMaxFlow dinic = new DinicMaxFlow(n);
        dinic.addEdge(0, 1, 10);
        dinic.addEdge(0, 2, 10);
        dinic.addEdge(1, 3, 4);
        dinic.addEdge(1, 4, 8);
        dinic.addEdge(1, 2, 2);
        dinic.addEdge(2, 4, 9);
        dinic.addEdge(3, 5, 10);
        dinic.addEdge(4, 3, 6);
        dinic.addEdge(4, 5, 10);

        long maxFlow = dinic.maxFlow(source, sink);
        System.out.println("Maximum Flow: " + maxFlow);

        // Expected result for this standard graph is 19
        if (maxFlow == 19) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed! Expected 19.");
        }
    }
}
