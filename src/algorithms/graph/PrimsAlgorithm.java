package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Prim's Algorithm to Find Minimum Spanning Tree (MST) of a Weighted Undirected Graph
 *
 * Prim's Algorithm finds a subset of the edges that connects all vertices with the minimum possible total edge weight,
 * forming a Minimum Spanning Tree (MST).
 *
 * It starts from a given source vertices and adds lowest-weight edge adjacent to MST formed such that one vertex outside is included in MST.
 * 
 * If there are V vertices then MST will have V-1 edges.
 *
 * Time Complexity:
 *   - Using Adjacency Matrix: O(V^2)
 *   - Using Adjacency List with PriorityQueue (Min Heap): O((V + E) log V)
 *
 * Space Complexity:
 *   - O(V^2) for adjacency matrix and O(V + E) for adjacency list
 *
 * Notes:
 *   - Only works on connected, weighted, undirected graphs
 *   - If the graph is disconnected, MST cannot be formed
 *   - The adjacency list approach is significantly better for sparse graphs (when E ≪ V²), 
 *     which is often the case in real-world problems.
 *
 * Example:
 *   Input Graph (Adjacency Matrix):
 *     0 2 3
 *     2 0 1
 *     3 1 0
 *
 *   Output:
 *     MST Weight: 3 (edges selected: 0-1, 1-2)
 */

public class PrimsAlgorithm {
    public static void main(String[] args) {
        //symmetric matrix for undirected graph
        int[][] grid = {
                    {0, 2, 3},
                    {2, 0, 1},
                    {3, 1, 0}
                };
        
        System.out.println("MST Weight : "+primsAlgorithmGrid(grid));
        
        ArrayList<ArrayList<Pair>> adj = convertGridIntoAdjList(grid);
        System.out.println("MST Weight : "+primsAlgorithmAdjList(adj));
        
    }

    //Time Complexity: O(V^2)
    //Space Complexity: O(V^2) => key[], mSet[] -> O(V), Input matrix -> O(V^2)
    private static int primsAlgorithmGrid(int[][] grid){

        int n = grid.length; //total number of vertices
        
        boolean[] mSet = new boolean[n]; //to track vetices included in MST
        int[] key = new int[n]; //to record final weights for all vertices
        Arrays.fill(key, Integer.MAX_VALUE);
        
        int source = 0;
        key[source] = 0; //weight will be zero for source
        int res = 0; //total weight of vertices included

        //this whole loop takes O(V^2) time
        for(int count = 0; count<n; count++){ //count from 0 to n-1 for all vertices
            int u = -1;
            for(int i=0; i<n; i++){
                if(!mSet[i] && (u==-1 || key[i] < key[u]))
                    u = i;
            }
            
            if(u == -1) return -1; // graph is not connected, so MST cannot be formed

            //adding vertice of minimum weight to MST
            mSet[u] = true;
            res += key[u];

            //relaxing all adjacent nodes
            for(int v=0; v<n; v++){
                if(!mSet[v] && grid[u][v] > 0 && key[v] > grid[u][v])
                    key[v] = grid[u][v];
            }
        }

        return res; //returning total weight
    }

    //Time Complexity: O((V + E) log V)
    //Each vertex is added once to the MST → O(V log V) due to priority queue
    //Each edge can cause at most one pq.add() → O(E log V)

    //Space Complexity: O(V + E) -> Adjacency list, O(V) -> key[], mSet[], PriorityQueue
    private static int primsAlgorithmAdjList(ArrayList<ArrayList<Pair>> adj){
        int n = adj.size();

        int count = 0; //to count total vertices included in MST
        boolean[] mSet = new boolean[n];
        
        int[] key = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int source = 0;
        key[source] = 0;
        pq.add(new Pair(source, 0)); //adding source into pq with weight 0

        int res = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll(); //Pair with minimum weight

            //if vertice is already included in MST, skip it
            if(mSet[curr.vertex])
                continue;
            
            //otherwise add vertice into MST
            mSet[curr.vertex] = true;
            res += curr.weight;
            count++;

            //iterating through different connected edges
            for(Pair edge : adj.get(curr.vertex)){

                if(!mSet[edge.vertex] && key[edge.vertex] > edge.weight){
                    key[edge.vertex] = edge.weight;
                    pq.add(new Pair(edge.vertex, edge.weight));
                }
            }
        }
       
        if (count < n) return -1;  //disconnected graph


        return res;
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

    private static class Pair implements Comparable<Pair>{
        int vertex;
        int weight;

        Pair(int v, int w){
            this.vertex = v;
            this.weight = w;
        }

        @Override
        public int compareTo(Pair that){
            return this.weight - that.weight;
        }
    }
}