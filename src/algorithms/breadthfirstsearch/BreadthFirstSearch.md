# Overview of the Breadth First Search (BFS) Code in Java 💻

## What's Happening in the Code? ❓

The provided Java code implements Breath First Search (BFS), a fundamental graph traversal algorithm. Let's walk through
the details!

### 1. **Setting Up the Graph** 📝

We start by creating a graph structure using an **adjacency list**, represented by a `List` of `List<Integer>`. Each
index in the main list corresponds to a vertex, and each sublist contains its neighboring vertices. This makes it easy
to keep track of which nodes are connected.

```java
private List<List<Integer>> adjList;
```

### 2. **Constructing the Graph** ⚙️

The `BreadthFirstSearch` constructor initializes the adjacency list with `numVertices` empty lists:

```java
public BreadthFirstSearch(int numVertices) {
    adjList = new ArrayList<>();
    for (int i = 0; i < numVertices; i++) {
        adjList.add(new ArrayList<>());
    }
}
```

### 3. **Adding Edges** ➕

The `addEdge` method links two vertices, `from` and `to`, by adding each to the other's adjacency list:

```java
public void addEdge(int from, int to) {
    adjList.get(from).add(to);
    adjList.get(to).add(from);
}
```

This makes it an **undirected graph**, where the connection between nodes goes both ways.

### 4. **The BFS Iterative Method** ↪️

The `bfsIteratice` method sets up an array called `visited` to keep track of which nodes have been visited during the
traversal,
as well setting up a `queue` to process the vertices level by level:

```java
public void bfsIterative(int start) {
    boolean[] visited = new boolean[adjList.size()];
    Queue<Integer> queue = new LinkedList<>();

    visited[start] = true;
    queue.add(start);

    System.out.println("Iterative: ");
    while (!queue.isEmpty()) {
        int vertex = queue.poll();
        System.out.print(vertex + " ");

        //Traverse all adjacent vertices
        for (int adj : adjList.get(vertex)) {
            if (!visited[adj]) {
                visited[adj] = true;
                queue.add(adj);
            }
        }
    }
}
```

### 5. **The BFS Recursive Method** 🔄

The main `bfsRecursive` method sets up an array called `visited` to keep track of which nodes have been visited during
the traversal,
as well setting up a `queue` to process the vertices level by level then, it calls the util function:

```java
public void bfsRecursive(int start) {
    boolean[] visited = new boolean[adjList.size()];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);

    System.out.println("Recursive: ");
    bfsRecursiveUtil(queue, visited);
}
```

### 6. **BFS Utility Method** ❤️

The `bfsRecursiveUtil` method is the heart of the algorithm. It recursively visits nodes, prints and dequeues them as it
goes:

```java
private void bfsRecursiveUtil(Queue<Integer> queue, boolean[] visited) {
    //Base case: stop if the queue is empty
    if (queue.isEmpty()) {
        return;
    }
    int vertex = queue.poll();

    //Not visited yet case
    if (!visited[vertex]) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        //Enqueue all unvisited adjacent vertices
        for (int adj : adjList.get(vertex)) {
            if (!visited[adj]) {
                queue.add(adj);
            }
        }
    }
    //Recursive call
    bfsRecursiveAux(queue, visited);
}
```

- **Visit**: The current node is marked as visited and printed.
- **Recur**: For each unvisited neighbor, `bfsUtil` is called recursively.

### 6. **Main Method** 💪

Finally, the `main` method demonstrates the BFS by building a sample graph and starting the traversal from vertex `0`:

```java
public static void main(String[] args) {
    BreadthFirstSearch graph = new BreadthFirstSearch(6);

    //Adding edges to the graph
    graph.addEdge(0, 1);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 5);

    //Perform both BFS approaches
    graph.bfsIterative(0);
    System.out.println("");
    graph.bfsRecursive(0);
}
```

## What Happens When You Run It? ⏳

1. The graph is created with 6 vertices.
2. Edges are added between the vertices to form connections.
3. BFS starts from vertex `0` and traverses reachable vertices layer by layer.

### Example Output: ✅

If you run the code, you might see an output like:

```
Breadth First Search starting from vertex 0:
0 1 3 4
```

This output shows the order in which the vertices are visited during the BFS traversal.

## Fun Fact: 🧐

BFS is great for finding the shortest path in unweighted graphs, which is very useful for GPS Navigation systems.

And that’s how BFS works in Java!

### Created by

David Bernal based on the job done by Nkeiruka Whenu
