package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class KruskalsAlgorithm {

    /*
     * Algorithm:
     * 1. Sort all edges in increasing order.
     * 2. Initialize : MST = { }, res = 0
     * 3. Do following for every edge 'e':
     *    while MST size does not become V-1:
     *        if adding current edge to MST does not cause a cycle:
     *              MST = MST U {e}
     *              res = res + e.weight
     * 
     * Notes : 
     *  - Here, we do not use matrix or adjacency list because finding all egdes and sorting them become complicated.
     *  - So, we will represent graph as an array of edges.
     */

     
    public static void main(String[] args) {
        int[][] grid  = {
            {0, 2, 3},
            {2, 0, 1},
            {3, 1, 0}
        };

        Edge[] edges = gridToEdges(grid);

    }

    private static Edge[] gridToEdges(int[][] grid){

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0){
                    edges.add(new Edge(i, j, grid[i][j]));
                }
            }
        }

        return edges.toArray(new Edge[0]); 
    }
    private static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        public int compareTo(Edge that){
            return this.wt - that.wt; //ascedning order based on edge's weight
        }

    }
    
}