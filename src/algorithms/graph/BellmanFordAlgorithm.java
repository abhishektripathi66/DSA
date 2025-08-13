package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;


/*
 * Bellman–Ford Algorithm for Shortest Paths in Directed/Undirected Graphs
 *
 * Given a weighted directed or undirected graph represented as an edge list,
 * the Bellman–Ford algorithm computes the shortest distance from a single source vertex
 * to all other vertices. It can handle graphs with negative weight edges, and it also
 * detects if a negative weight cycle exists.
 *
 * Time Complexity:
 *   - O(V * E)
 *
 * Space Complexity:
 *   - O(V) for the distance array.
 *
 * Notes:
 *   - Works for graphs with negative edge weights.
 *   - If the graph is undirected, each undirected edge (u, v) should be represented
 *     as two directed edges (u → v) and (v → u).
 *   - Not suitable for graphs with negative weight cycles (shortest path is undefined).
 *
 * Example:
 *   Input Edge List:
 *     0 1 4
 *     0 2 5
 *     1 2 -3
 *     2 3 4
 *
 *   Output (distances from vertex 0):
 *     0 4 1 5
 */

public class BellmanFordAlgorithm {
    public static void main(String[] args){

        //directed
        int[][] grid  = {
            {0, 2, 3},
            {0, 0, 1},
            {0, 0, 0}
        };

        int V = grid.length;
        int source = 0;
        //convert given matrix into array of edges
        Edge[] edges = gridToEdges(grid, true);

        bellmanFordAlgorithm(edges, source, V);
    }

    private static void bellmanFordAlgorithm(Edge[] edges,  int source, int V){
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0; //make distance for source 0

        //do relaxation V-1 times for all edges
        for(int count = 0; count < V-1; count++){
            
            for(Edge edge : edges){
                int u = edge.src;
                int v = edge.dest;

                if(dist[u]!=Integer.MAX_VALUE && dist[v] > dist[u] + edge.wt){
                    dist[v] = dist[u] + edge.wt;
                }
            }
        }


        //if relaxation could happen in Vth iteration then it is a negative cycle
         for(Edge edge : edges){
            int u = edge.src;
            int v = edge.dest;

            if(dist[u]!=Integer.MAX_VALUE && dist[v] > dist[u] + edge.wt){
                System.out.println("Negative weight cycle found");
                return;
            }
        }

        //print all vertices distance from source
        System.out.println("Shortest distance from source " + source + ":");
        for (int v = 0; v < dist.length; v++) {
            if (dist[v] == Integer.MAX_VALUE) {
                System.out.println("vertex " + v + " is unreachable");
            } else {
                System.out.println("vertex " + v + ", distance: " + dist[v]);
            }
        }
    }

    //based on given directed or undirected graph it will return array of edges
    private static Edge[] gridToEdges(int[][] grid, boolean directed) {
        ArrayList<Edge> edges = new ArrayList<>();
        int V = grid.length;

        for (int i = 0; i < V; i++) {
            for (int j = (directed ? 0 : i + 1); j < V; j++) {
                if (i != j && grid[i][j] != 0) { //i != j to avoid self-loops and grid[i][j] != 0 for negative edges
                    edges.add(new Edge(i, j, grid[i][j]));
                    if (!directed) {
                        edges.add(new Edge(j, i, grid[i][j]));
                    }
                }
            }
        }
        return edges.toArray(new Edge[0]);
    }

    private static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }


    }
}
