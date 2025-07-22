package algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/*
 * Detect Cycle in an Undirected Graph (Using DFS or BFS)
 *
 * Given an unweighted undirected graph represented as an adjacency matrix,
 * detect whether the graph contains a cycle. Since the graph may be disconnected, 
 * ensure that each component is checked.
 * A cycle in an undirected graph exists if during traversal, we encounter a 
 * visited node that is not the parent of the current node.
 *
 * Time Complexity:
 *   - O(V + E), where V is the number of vertices and E is the number of edges.
 *
 * Space Complexity:
 *   - O(V + E) for the adjacency list.
 *   - O(V) for the visited array and recursion/queue space.
 *
 * Example:
 *   Input adjacency matrix of cyclic graph:
 *     0 1 1 0
 *     1 0 1 0
 *     1 1 0 1
 *     0 0 1 0
 *
 *   Output:
 *     Graph contains cycle
 */

public class DetectCycleUndirectGraph {
    public static void main(String[] args){
        //cyclic graph
        int[][] grid = {{0, 1, 1, 0},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 0}};
       
        //acyclic graph
        // int[][] grid = {
        //     {0, 1, 0, 0},  
        //     {1, 0, 1, 1},
        //     {0, 1, 0, 0},
        //     {0, 1, 0, 0}  
        // };
        
        ArrayList<ArrayList<Integer>> adj = convertGridIntoAdjList(grid);
        boolean[] visited = new boolean[grid.length];

        boolean containsCycle = false;
        for(int i=0; i<grid.length; i++){
            if(!visited[i] && DFSRec(adj, i, visited, -1)){
                containsCycle = true;
                break;
            }
        }

        if(containsCycle)
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph does not contain cycle");
    }

    //using DFS travesal
    private static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, int parent){

        visited[s] = true;

        for(int u : adj.get(s)){
            if(!visited[u]){ //not visited yet
                if(DFSRec(adj, u, visited, s)) //check then return, do not return immediate result after first call
                    return true;
            }
            else if(u != parent) //already visited and not a parent then its cycle
                return true;
        }

        
        return false;
    }

    //using BFS traversal
    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int start, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    // If visited and not parent, cycle detected
                    return true;
                }
            }
        }

        return false;
    }

    //to convert adjacency matrix into an adjacency list for efficient traversal
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
