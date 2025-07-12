package DijkstrasAlgorithm;

import java.util.*;

class DijkstrasAlgorithm {
    // Node class for PriorityQueue (Min-Heap)
    static class Node implements Comparable<Node> {
        int vertex, weight;
        
        Node(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }
        
        // Compare based on weight (distance)
        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    // Dijkstra's Algorithm
    public static void dijkstra(Map<Integer, List<Node>> graph, int src, int V) {
        int[] dist = new int[V];  // Array to store shortest distances
        Arrays.fill(dist, Integer.MAX_VALUE);  // Initialize all distances to infinity
        dist[src] = 0;  // Distance from source to itself is 0

        PriorityQueue<Node> pq = new PriorityQueue<>(); // Min-Heap for selecting the shortest distance node
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();  // Get node with the smallest distance
            int u = current.vertex;

            // Traverse all neighbors of 'u'
            for (Node neighbor : graph.getOrDefault(u, new ArrayList<>())) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                // If a shorter path to 'v' is found
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));  // Add updated distance to PriorityQueue
                }
            }
        }

        // Print the shortest distances from the source node
        System.out.println("Shortest distances from source " + src + ": " + Arrays.toString(dist));
    }

    public static void main(String[] args) {
        int V = 5;  // Number of vertices
        Map<Integer, List<Node>> graph = new HashMap<>();

        // Graph representation as an adjacency list
        graph.put(0, Arrays.asList(new Node(1, 10), new Node(2, 3)));
        graph.put(1, Arrays.asList(new Node(2, 1), new Node(3, 2)));
        graph.put(2, Arrays.asList(new Node(1, 4), new Node(3, 8), new Node(4, 2)));
        graph.put(3, Arrays.asList(new Node(4, 7)));
        graph.put(4, Arrays.asList(new Node(3, 9)));

        dijkstra(graph, 0, V);  // Run Dijkstra from node 0
    }
}
