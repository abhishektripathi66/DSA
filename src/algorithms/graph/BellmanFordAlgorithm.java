package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;

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
        Edge[] edges = gridToEdges(grid, true);

        bellmanFordAlgorithm(edges, source, V);
    }

    private static void bellmanFordAlgorithm(Edge[] edges,  int source, int V){
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for(int count = 0; count < V-1; count++){
            
            for(Edge edge : edges){
                int u = edge.src;
                int v = edge.dest;

                if(dist[u]!=Integer.MAX_VALUE && dist[v] > dist[u] + edge.wt){
                    dist[v] = dist[u] + edge.wt;
                }
            }
        }


        //Vth iteration to check for negative cycle
         for(Edge edge : edges){
            int u = edge.src;
            int v = edge.dest;

            if(dist[u]!=Integer.MAX_VALUE && dist[v] > dist[u] + edge.wt){
                System.out.println("Negative weight cycle found");
                return;
            }
        }

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
            for (int j = 0; j < V; j++) {
                if (grid[i][j] > 0) {
                    edges.add(new Edge(i, j, grid[i][j]));
                    // For undirected, add edge j->i only if i != j and directed is false
                    if (!directed && i != j) {
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
