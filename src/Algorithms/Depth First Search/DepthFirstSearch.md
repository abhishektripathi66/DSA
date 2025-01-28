# Overview of the Depth First Search (DFS) Code in Java 💻
## What's Happening in the Code? ❓
The provided Java code implements Depth First Search (DFS), a fundamental graph traversal algorithm. Let me walk you through the details!
### 1. **Setting Up the Graph** 📝
We start by creating a graph structure using an **adjacency list**, represented by a `List` of `List<Integer>`. Each index in the main list corresponds to a vertex, and each sublist contains its neighboring vertices. This makes it easy to keep track of which nodes are connected.
```java
private List<List<Integer>> adjList;
```
### 2. **Constructing the Graph** ⚙️
The `DepthFirstSearch` constructor initializes the adjacency list with `numVertices` empty lists:
```java
public DepthFirstSearch(int numVertices) {
    adjList = new ArrayList<>();
    for (int i = 0; i < numVertices; i++) {
        adjList.add(new ArrayList<>());
    }
}
```
### 3. **Adding Edges** ➕
The `addEdge` method links two vertices, `v` and `w`, by adding each to the other's adjacency list:
```java
public void addEdge(int v, int w) {
    adjList.get(v).add(w);
    adjList.get(w).add(v); // Remove this for directed graphs
}
```
This makes it an **undirected graph**, where the connection between nodes goes both ways.
### 4. **The DFS Method** 🔄
The main `dfs` method sets up an array called `visited` to keep track of which nodes have been visited during the traversal:
```java
public void dfs(int start) {
    boolean[] visited = new boolean[adjList.size()];
    dfsUtil(start, visited);
}
```
### 5. **DFS Utility Method** ❤️
The `dfsUtil` method is the heart of the algorithm. It recursively visits nodes and prints them as it goes:
```java
private void dfsUtil(int vertex, boolean[] visited) {
    visited[vertex] = true;
    System.out.print(vertex + " ");

    for (int adj : adjList.get(vertex)) {
        if (!visited[adj]) {
            dfsUtil(adj, visited);
        }
    }
}
```
- **Visit**: The current node is marked as visited and printed.
- **Recur**: For each unvisited neighbor, `dfsUtil` is called recursively.
### 6. **Main Method** 💪
Finally, the `main` method demonstrates the DFS by building a sample graph and starting the traversal from vertex `0`:
```java
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
```
## What Happens When You Run It? ⏳
1. The graph is created with 6 vertices.
2. Edges are added between the vertices to form connections.
3. DFS starts from vertex `0` and traverses through its neighbors, exploring as far as possible along each branch before backtracking.
### Example Output: ✅
If you run the code, you might see an output like:
```
Depth First Search starting from vertex 0:
0 1 3 4 2 5
```
This output shows the order in which the vertices are visited during the DFS traversal.
## Fun Fact: 🧐
DFS is great for exploring maze-like structures and finding connected components in a graph. It dives deep into each path before backtracking, making it perfect for tasks like solving puzzles or exploring tree data structures.
And that’s how DFS works in Java!
### Created by
Nkeiruka Whenu
