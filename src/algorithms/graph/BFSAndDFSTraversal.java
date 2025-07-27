package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/*
 * BFS and DFS Traversal of a unweighted undirected/directed Graph
 *
 * Given an unweighted directed or undirected graph represented as an adjacency matrix,
 * and we have to do both Breadth-First Search (BFS) and Depth-First Search (DFS) traversals.
 * The graph may be disconnected, so we should cover all vertices using loops.
 *
 * Time Complexity:
 *   - O(V + E) for both BFS and DFS, where V is the number of vertices and E is the number of edges.
 *
 * Space Complexity:
 *   - O(V + E) for the adjacency list
 *   - O(V) for the visited array and recursion/queue space
 *
 * Example:
 *   Input Adjacency Matrix:
 *     0 1 1 0
 *     1 0 1 0
 *     1 1 0 1
 *     0 0 1 0
 *
 *   Output:
 *     BFS traversal : 0 1 2 3
 *     DFS traversal : 0 1 2 3
 */

public class BFSAndDFSTraversal {
    public static void main(String[] args) {
        //for undirected it is a symmetric matrix
        int[][] grid = {{0, 1, 1, 0},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 0}};


        // int[][] grid = {
        //     {0, 1, 1, 0, 0},
        //     {1, 0, 0, 1, 0},
        //     {1, 0, 0, 0, 1},
        //     {0, 1, 0, 0, 0},
        //     {0, 0, 1, 0, 0}
        // };
        /* Undirected graph from above grid
                      0
                     / \
                    1   2
                   /     \
                  3       4
            BFS traversal : 0 1 2 3 4
            DFS traversal : 0 1 3 2 4
        */


        // int[][] grid = {
        //     {0, 1, 1, 0, 0},  // 0 → 1, 2
        //     {0, 0, 0, 1, 0},  // 1 → 3
        //     {0, 0, 0, 0, 1},  // 2 → 4
        //     {0, 0, 0, 0, 0},  // 3 → none
        //     {0, 0, 0, 0, 0}   // 4 → none
        // };
        /* Directed graph from above grid
            0 → 1 → 3
            ↓
            2 → 4
            BFS traversal : 0 1 2 3 4
            DFS traversal : 0 1 3 2 4
        */

        ArrayList<ArrayList<Integer>> adj = convertGridIntoAdjList(grid);
        boolean[] visited = new boolean[grid.length];

        System.out.print("BFS traversal : ");
        for (int i = 0; i < grid.length; i++) //running loop because given graph might be disconnected
            if (!visited[i])
                bfsTraversal(adj, i, visited);

        Arrays.fill(visited, false);
        System.out.println();
        System.out.print("DFS traversal : ");
        for (int i = 0; i < grid.length; i++)
            if (!visited[i])
                dfsTraversal(adj, i, visited);
        System.out.println();
        //System.out.println("\nGraph View");
        //printGraph(adj);     
    }

    //using Queue for level by level traversal
    private static void bfsTraversal(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true; //to prevent adding same node multiple times
                    q.add(v);
                }
            }
        }
    }

    //using recursing call stack
    private static void dfsTraversal(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int v : adj.get(s)) {
            if (!visited[v])
                dfsTraversal(adj, v, visited);
        }
    }

    //it will convert given  unweighted directed or undirected graph's grid representation into adjacency list 
    private static ArrayList<ArrayList<Integer>> convertGridIntoAdjList(int[][] grid) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            adj.add(new ArrayList<Integer>());
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    adj.get(i).add(j);
            }
        }

        return adj;
    }

    @SuppressWarnings("unused")
    private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adj.get(i).size(); j++)
                System.out.print(adj.get(i).get(j) + " ");
            System.out.println();
        }
    }


}
