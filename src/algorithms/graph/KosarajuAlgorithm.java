package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * Kosaraju's Algorithm for Strongly Connected Components
 *
 * Given a directed graph, find all of its strongly connected components.
 * A strongly connected component is a maximal group of vertices where each
 * vertex is reachable from every other vertex in the same group.
 *
 * Kosaraju’s algorithm works in two DFS passes:
 *  1. First DFS on the original graph to compute vertices in decreasing order of finishing time.
 *  2. Reverse all edges of the graph.
 *  3. Second DFS on the reversed graph, visiting vertices in the finishing-time order
 *     obtained from the first pass. Each DFS tree in this pass gives one SCC.
 *
 * Time Complexity:
 *   - O(V + E) for both DFS passes combined, where V is the number of vertices and E is the number of edges.
 *
 * Space Complexity:
 *   - O(V + E) for the adjacency lists
 *   - O(V) for the visited array and recursion stack
 *
 * Example:
 *   Input Directed Graph (Adjacency Matrix):
 *       0 → 1
 *       ↑   ↓
 *       2 ← 3 → 4
 *
 *   SCCs:
 *       {0, 1, 2} and {3} and {4}
 *
 * Steps:
 *   1. First DFS finishing-time order: 4, 3, 0, 1, 2
 *   2. Reverse graph edges.
 *   3. Second DFS on reversed graph:
 *        - Start at 2: visit 2, 1, 0 → SCC {0, 1, 2}
 *        - Start at 3: visit 3 → SCC {3}
 *        - Start at 4: visit 4 → SCC {4}
 */

public class KosarajuAlgorithm {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0}
        };
        
        //fist get the list of vertices inn decreasing order of finish time          
        ArrayList<ArrayList<Integer>>  adj = convertGridIntoAdjList(grid);
        boolean[] visited = new boolean[grid.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < grid.length; i++) {
            if (!visited[i]) {
                DFSForOrderList(i, adj, visited, st);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(); // vertices in decreasing finish time; same as topological order if graph is a DAG
        while(!st.isEmpty()){
            list.add(st.pop());
        }

        //reverse the edges
        ArrayList<ArrayList<Integer>>  revAdj = convertGridIntoRevAdjList(grid);

        //run DFS again on retrieved list because strongly connectded componet will stay connected in same way
        Arrays.fill(visited, false);
        for(int i=0; i<list.size(); i++){
            if(!visited[list.get(i)]){
                System.out.print("Strongly connected component from "+list.get(i)+" : ");
                dfsTraversal(list.get(i), revAdj, visited);
                System.out.println();
            }
        }
        
    }

    private static void dfsTraversal(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");
        for (int v : adj.get(u)) {
            if (!visited[v])
                dfsTraversal(v, adj, visited);
        }
    }

    public static void DFSForOrderList(int u, ArrayList<ArrayList<Integer>>  adj, boolean[] visited, Stack<Integer> st){
        visited[u] = true;

        for(int v : adj.get(u)){
            if(!visited[v])
                DFSForOrderList(v, adj, visited, st);
        }

        st.push(u); // push after visiting all neighbors
    }


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

    private static ArrayList<ArrayList<Integer>> convertGridIntoRevAdjList(int[][] grid) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        //create all empty adjacency lists first
        for (int i = 0; i < grid.length; i++) {
            adj.add(new ArrayList<>());
        }

        //now add reversed edges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    adj.get(j).add(i); // reverse edge
            }
        }
        return adj;
    }
}
