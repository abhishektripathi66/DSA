# Overview of the Fibonacci Search (FS) Code in Java 💻

## What's Happening in the Code? ❓

The provided Java code implements Fibonacci Search, an efficient search algorithm for sorted arrays. Let me walk you through the details!

### 1. **Setting the Initial Indices** 📌

First, we initialize three Fibonacci numbers:

* `fib2` → The second-to-last Fibonacci number before the largest one (`fib = 13`), so `fib2 = 8`.
* `fib1` → The number before `fib2`, so `fib1 = 5`.
* `fib` → The largest Fibonacci number found in the first step (`fib = 13`).

```
int fib2 = 0;  // (fib(n-2))
int fib1 = 1;  // (fib(n-1))
int fib = fib2 + fib1;  // (fib(n))
```

We also define `offset = -1`, which helps adjust the indices correctly.

```
int offset = -1;
```

### 2. Preparing the Fibonacci Numbers 🔢

Next, we find the smallest **Fibonacci number** that is greater than or equal to the size of the array. This helps us determine how to divide the array during the search. Example: If the array has `n = 10` elements, we use the Fibonacci number `13` because it is the smallest number larger than `10`.

```java
// Finding the smallest Fibonacci number greater than or equal to n
while (fib < n) {
    fib2 = fib1;
    fib1 = fib;
    fib = fib2 + fib1;
}
```

### 3. **Choosing the First Search Point** 🎯

The first index to check is **(offset + fib2)** because `fib2` represents the best initial position based on the Fibonacci numbers.

```java
while (fib > 1) {
    int i = Math.min(offset + fib2, n - 1);
  
    //the remaning code ...
```

### 4. **Comparing Values** 🔍

At this point, we check three possibilities:

* **If the value at the index matches the target** ✅ → We’ve found the element, success!
* **If the value is less than the target** ⬆️ → The target must be on the **right** side. We update `offset` and reduce the Fibonacci numbers.
* **If the value is greater than the target** ⬇️ → The target must be on the **left** side. We reduce `fib` to search a smaller portion of the array.

```java
    if (arr[i] < target) {  // Move right
        fib = fib1;
        fib1 = fib2;
        fib2 = fib - fib1;
        offset = i;
    } else if (arr[i] > target) {  // Move left
        fib = fib2;
        fib1 -= fib2;
        fib2 = fib - fib1;
    } else {  // Found the target
        return i;
    }
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
Element found at index 6
```

This output shows the index of the searched value.

## Fun Fact: 🧐

Despite being inspired by the famous Fibonacci sequence, it's not used much in practice! The idea of using Fibonacci numbers to divide the array is mathematically elegant, but in most cases, binary search is more efficient and easier to implement.
But calm down! It's still useful in cases where memory access times are unequal, such as in hierarchical memory systems (for example, reading from old magnetic tapes), where access to closer elements is less costly.

### Created by

José Neto
