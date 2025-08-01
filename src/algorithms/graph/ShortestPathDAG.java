package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/*
 * Shortest Path in a Directed Acyclic Graph (DAG) using Topological Sorting
 *
 * This class demonstrates how to find the shortest path from a given source vertex
 * in a weighted Directed Acyclic Graph (DAG) using a topological order-based approach.
 *
 * Key Concepts:
 *   - The graph is first checked for cycles using Kahn’s algorithm (BFS-based Topological Sort).
 *   - If the graph is acyclic, shortest paths are computed using edge relaxation
 *     in topological order.
 *
 * Input:
 *   - A weighted DAG represented as an adjacency matrix.
 *   - Each non-zero entry grid[i][j] indicates a directed edge from i to j with a weight.
 *
 * Output:
 *   - Shortest distances from the given source vertex to all other vertices.
 *
 * Time Complexity:
 *   - O(V + E), where V is the number of vertices and E is the number of edges.
 *
 * Space Complexity:
 *   - O(V + E) for the adjacency list
 *   - O(V) for distance, indegree, and visited structures
 *
 * Example:
 *   Input Adjacency Matrix (weighted):
 *     0 2 3 6 0 0 0 0
 *     0 0 0 0 1 4 0 0
 *     0 0 0 0 0 0 0 0
 *     0 0 0 0 0 0 2 0
 *     0 0 0 0 0 0 0 0
 *     0 0 0 0 0 0 0 1
 *     0 0 0 0 0 0 0 1
 *     0 0 0 0 0 0 0 0
 *
 *   Output:
 *     Shortest Path from source 0:
 *     Vertex 0 : 0
 *     Vertex 1 : 2
 *     Vertex 2 : 3
 *     Vertex 3 : 6
 *     Vertex 4 : 3
 *     Vertex 5 : 6
 *     Vertex 6 : 8
 *     Vertex 7 : 7
 */



public class ShortestPathDAG {
    public static void main(String[] args) {

        //weighted directed acyclic graph
        

        //Graph
        /*
                  0
                / | \
               1  2  3
              / \     \
             4   5     6
                    \ /
                     7
         */
        //With weights (format: u -w-> v):
        /*
        0 -2-> 1, 0 -3-> 2, 0 -6-> 3  
        1 -1-> 4, 1 -4-> 5  
        3 -2-> 6  
        5 -1-> 7  
        6 -1-> 7
        */

        int[][] grid = {
            //0  1  2  3  4  5  6  7
            { 0, 2, 3, 6, 0, 0, 0, 0 },  // 0
            { 0, 0, 0, 0, 1, 4, 0, 0 },  // 1
            { 0, 0, 0, 0, 0, 0, 0, 0 },  // 2
            { 0, 0, 0, 0, 0, 0, 2, 0 },  // 3
            { 0, 0, 0, 0, 0, 0, 0, 0 },  // 4
            { 0, 0, 0, 0, 0, 0, 0, 1 },  // 5
            { 0, 0, 0, 0, 0, 0, 0, 1 },  // 6
            { 0, 0, 0, 0, 0, 0, 0, 0 }   // 7
        };


        ArrayList<ArrayList<Pair>> adj = convertGridIntoAdjList(grid);


        ArrayList<Integer> topologicalOrder = new ArrayList<>();
        if(hasCycleBFS(adj, topologicalOrder)){ //check that does graph has any cycle or not?
            System.out.println("Graph contains cycle so shortest path is not possible");
        }
        else{
            //for acyclic graph
            //using topological sort because first we have to complete all predecessors before completing current one
            //it ensures that current verices get a minimum distance from all other predecessors who's shortest distance is computed

            //here condsider is just single component and vertices are numbered from 0 to n-1
            int source = 0; //source 0 from where we have to find shorted distance for other vertices
            int[] dist = findShortestPath(source, topologicalOrder, adj);

            System.out.println("Shortest Path from given source "+source+" : ");
            for(int i=0; i<dist.length; i++){
                System.out.println("Vertex "+i+" : "+dist[i]);
            }
        }

    }

    private static int[] findShortestPath(int source, ArrayList<Integer> topologicalOrder, ArrayList<ArrayList<Pair>> adj){
        int n = adj.size();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for(int u : topologicalOrder){
            //iterating through each pair from ArrayList<Pair> pairs from adj.get(u)
            for(Pair p: adj.get(u)){
                if(dist[u] != Integer.MAX_VALUE && dist[p.vertex] > dist[u] + p.weight){
                    dist[p.vertex] = dist[u] + p.weight;
                }
            }
        }

        return dist;
    }

    // Kahn's Algorithm to check cycle and find topological sort
    private static boolean hasCycleBFS(ArrayList<ArrayList<Pair>>  adj, ArrayList<Integer> topologicalOrderList){
        int n = adj.size();

        int[] indegree = new int[n];
        for(int i=0; i<n; i++){

            for(Pair p : adj.get(i))
                indegree[p.vertex]++;
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

            for(Pair p : adj.get(u)){
                indegree[p.vertex] --;
                //if all independent nodes/jobs are done for current dependent node, add that in queue to process
                if(indegree[p.vertex] == 0)
                    q.add(p.vertex);
            }

        }

        return count!=n;
    }

    
    private static ArrayList<ArrayList<Pair>> convertGridIntoAdjList(int[][] grid) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            adj.add(new ArrayList<Pair>());
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0)
                    adj.get(i).add(new Pair(j, grid[i][j]));
            }
        }

        return adj;
    }

    private static class Pair{
        int vertex;
        int weight;

        Pair(int v, int w){
            this.vertex = v;
            this.weight = w;
        }
    }

}
