package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;


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
*
* Time Complexity:
*    - O(E log E + E * α(V)), where α is the inverse Ackermann function (very small).
*/

public class KruskalsAlgorithm {
     
    public static void main(String[] args) {
        //undirected graph
        int[][] grid  = {
            {0, 2, 3},
            {2, 0, 1},
            {3, 1, 0}
        };

        Edge[] edges = gridToEdges(grid);
        int V = grid.length;

        System.out.println("Total MST Weight : "+kruskalsAlgorithm(edges, V));

    }

    private static int kruskalsAlgorithm(Edge[] edges, int V){
        int[] parent = new int[V];
        int[] rank = new int[V];

        //sorting edges based on their weights
        Arrays.sort(edges);

        for(int i=0; i<V; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        int res = 0;

        //output array for all selected eges
        Edge[] outputEdges = new Edge[V-1];
        for(int i=0, s=0; s<V-1; i++){

            Edge e = edges[i];
            int x = find(e.src, parent);
            int y = find(e.dest, parent);

            if(x != y){ //if does belong to same set, mering them will not create a cycle
                outputEdges[s] = e;
                s++;

                res+= e.wt;
                union(x, y, parent, rank); //both verices selected, so put them in the same set
            }
        }

        //optional: print MST edges
        System.out.println("Edges in MST:");
        for (Edge e : outputEdges) {
            System.out.println(e.src + " - " + e.dest + " = " + e.wt);
        }

        return res;
    }

    private static int find(int x, int[] parent){
        if(x != parent[x])
            return parent[x] = find(parent[x], parent); //path compression
        
        //seperate node or root of the tree
        return parent[x]; //x 
    }

    private static void union(int x, int y, int[] parent, int[] rank){
        int px = find(x, parent);
        int py = find(y, parent);

        //if both parents are not in same same
        //while doing union, attach smaller rank node to higher rank node
        if(px != py){
            
            if(rank[px] < rank[py]){
                parent[px] = py;
            }
            else if(rank[px] > rank[py]){
                parent[py] = px;
            }
            else{
                parent[px] = py;
                rank[py]++;

                //parent[py] = px;
                //rank[px]++;
            }
        }
    }

    private static Edge[] gridToEdges(int[][] grid){

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = i+1; j < grid[0].length; j++) { // j = i+1 to avoid duplicate undirected edges
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