###### Overview of Dijkstra’s Algorithm in Java 🚀
## What Does This Code Do? 🤔
The Java code implements Dijkstra’s Algorithm, which finds the shortest path from a source node to all other nodes in a weighted graph. It uses a Priority Queue (Min-Heap) to always process the shortest known distance first.

1. ## Understanding the Graph Representation 🎭
The algorithm works on a graph, which is represented as an adjacency list using a HashMap.
Each node is connected to other nodes with specific weights (distances).

Example Graph:

      (A)
     /   \
   10     3
   /       \
 (B)---1---(C)---8--(D)
  |         |
  2         4
  |         |
 (E)-------(F)
       2
This graph would be represented as:

```java
graph.put(0, Arrays.asList(new Node(1, 10), new Node(2, 3)));
graph.put(1, Arrays.asList(new Node(2, 1), new Node(3, 2)));
graph.put(2, Arrays.asList(new Node(1, 4), new Node(3, 8), new Node(4, 2)));
graph.put(3, Arrays.asList(new Node(4, 7)));
graph.put(4, Arrays.asList(new Node(3, 9)));
```


## 2. Setting Up the Algorithm 🔢
Before we start, we initialize:

✅ Distance array (dist) → Stores shortest distances (initialized to Infinity except for the source node, which is 0).
✅ Priority Queue (pq) → A Min-Heap (Priority Queue) that always picks the node with the smallest known distance.
✅ Visited set (visited) → Tracks nodes that are already processed.

```java
int[] dist = new int[V]; // Stores shortest distances
Arrays.fill(dist, Integer.MAX_VALUE); // Initially set all distances to infinity
dist[src] = 0; // Distance from source to itself is 0

PriorityQueue<Node> pq = new PriorityQueue<>(); // Min-Heap for shortest distance
pq.add(new Node(src, 0)); // Start with the source node

```


## 3. Processing Nodes Using Min-Heap (Priority Queue) 🏗️
The algorithm works as follows:

🔹 Step 1: Extract the node with the smallest distance from the priority queue.
🔹 Step 2: For each neighbor of this node, check if a shorter path exists via the current node.
🔹 Step 3: If a shorter path is found, update the distance and push the neighbor to the queue.
🔹 Step 4: Repeat until all nodes are processed.


```java
while (!pq.isEmpty()) {
    Node current = pq.poll(); // Get the node with the smallest distance
    int u = current.vertex;

    // Traverse all neighbors of 'u'
    for (Node neighbor : graph.getOrDefault(u, new ArrayList<>())) {
        int v = neighbor.vertex;
        int weight = neighbor.weight;

        // If a shorter path to 'v' is found
        if (dist[u] + weight < dist[v]) {
            dist[v] = dist[u] + weight;
            pq.add(new Node(v, dist[v])); // Add updated distance to PriorityQueue
        }
    }
}
```
## 4. Stopping Condition 🚦
The algorithm stops when:

✔️ All nodes have been processed.
✔️ The priority queue is empty (all reachable nodes have been visited).

## 5. Printing the Final Shortest Distances 📢
After processing all nodes, we print the shortest distance from the source node to every other node.

```java
System.out.println("Shortest distances from source " + src + ": " + Arrays.toString(dist));
```

Example Output:

Shortest distances from source 0: [0, 7, 3, 9, 5]
This means:
✅ 0 → 0 (itself)
✅ 1 → 7
✅ 2 → 3
✅ 3 → 9
✅ 4 → 5

## 6. Full Java Code 💻


```java
import java.util.*;

class DijkstraAlgorithm {
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

```

## Why Use Dijkstra’s Algorithm? 🤷‍♂️
✅ Works well with graphs that have positive weights
✅ Used in navigation systems (e.g., Google Maps 🚗)
✅ More efficient than Floyd-Warshall for single-source shortest paths


## Comparison with Other Shortest Path Algorithms 📊
Algorithm	       Best for	                          Time Complexity	         Space Complexity
Dijkstra	       Single-source shortest path	      O((V + E) log V)	         O(V + E)
Floyd-Warshall	   All-pairs shortest path	          O(V³)	                     O(V²)



Created by Dharani 😊 🎉