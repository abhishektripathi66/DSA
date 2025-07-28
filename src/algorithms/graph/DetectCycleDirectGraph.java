package algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/* Cycle Detection in a Directed Graph using BFS (Kahn’s Algorithm) and DFS
 *
 * This class provides methods to detect cycles in a directed graph using:
 *   1. Kahn's Algorithm (BFS-based Topological Sort)
 *   2. Depth-First Search (DFS) with a recursion stack
 *
 * The input graph is represented as an adjacency list converted from an adjacency matrix.
 * These methods work for both connected and disconnected components.
 *
 * Approach:
 *   - Kahn’s Algorithm:
 *       - Track in-degrees of all vertices.
 *       - Use a queue to process nodes with in-degree 0.
 *       - If we can't process all vertices, the graph has a cycle.
 *
 *   - DFS with Recursion Stack:
 *       - Use visited[] to mark visited nodes.
 *       - Use recSt[] to track the current DFS path.
 *       - A back edge (to a node in recStack) indicates a cycle.
 *
 * Input:
 *   - A directed graph represented as an adjacency matrix.
 *     Example:
 *       0 1 1 0
 *       1 0 1 0
 *       1 1 0 1
 *       0 0 1 0
 *
 * Output:
 *   - Whether the graph contains a cycle (true/false).
 *   - Topological sort if no cycle exists (optional).
 *
 * Time Complexity:
 *   - O(V + E) for both Kahn’s and DFS approaches.
 *
 * Space Complexity:
 *   - O(V + E) for the adjacency list
 *   - O(V) for visited, recursion stack, and queue
 *
 * Notes:
 *   - This implementation supports disconnected graphs by checking all components.
 *   - Topological sorting is only valid for Directed Acyclic Graphs (DAGs).
 */


public class DetectCycleDirectGraph {
    public static void main(String[] args) {
        //directed cyclic graph
        // int[][] grid = {{0, 1, 1, 0},
        //         {1, 0, 1, 0},
        //         {1, 1, 0, 1},
        //         {0, 0, 0, 0}};
        //adj. representation
        //0 → [1, 2]  
        //1 → [0, 2]  
        //2 → [0, 1, 3]  
        //3 → []
        

        //directed acyclic graph
        int[][] grid = {{0, 1, 1, 0},
                        {0, 0, 0, 1},
                        {0, 0, 0, 1},
                        {0, 0, 0, 0}};
        //adj. representation
        //0 → [1, 2]
        //1 → [3]
        //2 → [3]
        //3 → []
         
        ArrayList<ArrayList<Integer>> adj = convertGridIntoAdjList(grid);

        System.out.println("Using Kahn's (BFS) Algorithm:");
        ArrayList<Integer> topoBFS = new ArrayList<>();
        if(hasCycleBFS(adj, topoBFS)){
            System.out.println("Graph contains cycle");
        }
        else{
            System.out.println("Graph does not contain cycle");
            System.out.println("Topological Sort (BFS): " + topoBFS);
        }

        System.out.println("\nUsing DFS Algorithm:");
        ArrayList<Integer> topoDFS = new ArrayList<>();
        if (hasCycleDFS(adj, topoDFS)) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph does not contain cycle");
            System.out.println("Topological Sort (DFS): " + topoDFS);
        }

    }

    // Kahn's Algorithm for Topological sort
    private static boolean hasCycleBFS(ArrayList<ArrayList<Integer>>  adj, ArrayList<Integer> topologicalOrderList){
        int n = adj.size();

        int[] indegree = new int[n];
        for(int i=0; i<n; i++){

            for(int v : adj.get(i))
                indegree[v]++;
            
            //can not be used with adj but can with grid
            // for(int j=0; j<n; j++){
            //     if(adj.get(i).get(j) == 1)
            //         indegree[j]++;
            // }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            
            int u = q.poll();
            topologicalOrderList.add(u);
            count++;

            for(int v : adj.get(u)){
                indegree[v] --;
                //if all independent nodes/jobs are done for current dependent node, add that in queue to process
                if(indegree[v] == 0)
                    q.add(v);
            }

        }

        //for cycle, count will not be same as total number vertice
        return count!=n;
    }

    // DFS-based cycle detection
    private static boolean hasCycleDFS(ArrayList<ArrayList<Integer>>  adj, ArrayList<Integer> topologicalOrderList){
        int n = adj.size();
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (DFSUtil(i, adj, visited, recStack, st))
                    return true;
            }
        }

        //it will print topological sort, only if ALL disconnected components do not have a cycle
        while(!st.isEmpty())
            topologicalOrderList.add(st.pop());

        return false;
    }

    private static boolean DFSUtil(int u, ArrayList<ArrayList<Integer>>  adj, boolean[] visited, boolean[] recSt, Stack<Integer> st){
        visited[u] = true;
        recSt[u] = true;

        for(int v : adj.get(u)){
            if(!visited[v]){
                if(DFSUtil(v, adj, visited, recSt, st))
                    return true;
            }
            else if(recSt[v])
                return true; //back edge → cycle
        }
        recSt[u] = false;
        st.push(u); //Post-order push for topological sort
        return false;
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

}