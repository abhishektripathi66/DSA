package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


/*
 * Dijkstra's Algorithm to Find Shortest Paths from a Source in a Weighted Graph
 *
 * Dijkstra's Algorithm computes the shortest path distances from a given source vertex
 * to all other vertices in a weighted graph with non-negative edge weights.
 *
 * The algorithm maintains a set of "finalized" vertices whose shortest distances are already known,
 * and iteratively selects the unfinalized vertex with the smallest tentative distance,
 * relaxing its adjacent vertices.
 *
 * Time Complexity:
 *   - Using Adjacency Matrix: O(V^2)
 *   - Using Adjacency List with PriorityQueue (Min Heap): O((V + E) log V)
 *
 * Space Complexity:
 *   - O(V^2) for adjacency matrix, O(V + E) for adjacency list
 *   - Plus O(V) for distance and finalized arrays
 *
 * Notes:
 *   - Works for connected or disconnected graphs
 *   - Unreachable vertices will have distance = Integer.MAX_VALUE
 *   - Only works with non-negative edge weights
 *   - The adjacency list approach is more efficient for sparse graphs (E ≪ V²)
 * 
 * Difference from Prim's and Kruskal's Algorithm:
 * - Prim's and Kruskal's related to forming MST so negative edges are not concern for them but they work for an undirected graph only.
 * - Whereas Dijkstra's algorithm is related to shortest Path and not designed for handingling negative edges but it works for both
 * undirected and directed graph.
 *
 * Example:
 *   Input Graph (Adjacency Matrix):
 *     0 2 3
 *     2 0 1
 *     3 1 0
 *
 *   Output (source = 0):
 *     vertex 0, distance: 0
 *     vertex 1, distance: 2
 *     vertex 2, distance: 3
 */

public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 2, 3},
            {2, 0, 1},
            {3, 1, 0}
        };

        int source = 0;

        //Matrix Version
        int[] distMatrix = dijkstrasAlgorithmGrid(grid, source);
        System.out.println("Shortest distance (Adjacency Matrix) from source " + source + ":");
        printDistances(distMatrix);

        //convert to adjacency list
        ArrayList<ArrayList<Pair>> adj = convertGridIntoAdjList(grid);

        // List Version
        int[] distList = dijkstrasAlgorithmAdjList(adj, source);
        System.out.println("\nShortest distance (Adjacency List) from source " + source + ":");
        printDistances(distList);
        
    }

    //Time Complexity: O(V^2)
    //Space Complexity: O(V^2) => dist[], fin[] -> O(V), Input matrix -> O(V^2)
    private static int[] dijkstrasAlgorithmGrid(int[][] grid, int source){
        int n = grid.length;

        boolean[] fin = new boolean[n]; //for finalized vertices
        int[] dist = new int[n]; //to store each vertice distace from the source

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for(int count=0; count<n-1; count++){
            int u = -1;
            //taking vertice with minimum distance
            for(int i=0; i<n; i++){
                if(!fin[i] && (u==-1 || dist[i] < dist[u]))
                    u = i;
            }
            
            if(u == -1) // no more reachable vertices 
                break;

            fin[u] = true; //finalize selected min-distant vertex
            
            //traverse all adjacent vertices of the current node
            for(int v=0; v<n; v++){
                //if not finalized and there is a shorter path to v through u
                if(!fin[v] && grid[u][v]>0 && dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + grid[u][v])
                    dist[v] = dist[u] + grid[u][v];
            }
        }

        return dist;
    }

    //Time complexity : O((V + E) log V) -> Using adjacency list + priority queue
    //Space Complexity :  O(V + E) -> Adjacency list, O(V) -> fin[], dist[], PriorityQueue
    private static int[] dijkstrasAlgorithmAdjList(ArrayList<ArrayList<Pair>> adj, int source){

        int n = adj.size();

        boolean[] fin = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, 0));
        dist[source] = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            if(fin[curr.vertex])
                continue;
            
            fin[curr.vertex] = true;

            //relaxing all adjacents
            for(Pair edge : adj.get(curr.vertex)){
                
                //if(!fin[edge.vertex] && dist[edge.vertex] > curr.weight + adj.get(curr.vertex).get(edge.vertex).weight){ //wrong
                
                //use dist from source rather than curr.weight
                //adj.get(curr.vertex).get(edge.vertex).weight same as edge.weight
                if(!fin[edge.vertex] && dist[curr.vertex] != Integer.MAX_VALUE && dist[edge.vertex] > dist[curr.vertex] + edge.weight ){
                    dist[edge.vertex] = dist[curr.vertex] + edge.weight;
                    pq.add(new Pair(edge.vertex, dist[edge.vertex]));
                }
            }
        }

        return dist;
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

    private static void printDistances(int[] dist) {
        for (int v = 0; v < dist.length; v++) {
            if (dist[v] == Integer.MAX_VALUE) {
                System.out.println("vertex " + v + " is unreachable");
            } else {
                System.out.println("vertex " + v + ", distance: " + dist[v]);
            }
        }
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
            return this.weight - that.weight; //ascending order
        }
    }
}
