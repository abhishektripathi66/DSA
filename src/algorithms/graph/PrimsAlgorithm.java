package algorithms.graph;

import java.util.Arrays;


public class PrimsAlgorithm {
    public static void main(String[] args) {
        //undirected matrix
        int[][] grid = {
                    {0, 2, 3},
                    {2, 0, 1},
                    {3, 1, 0}
                };
        
        System.out.println("MST Weight : "+primsAlgorithmGrid(grid));
    }


    private static int primsAlgorithmGrid(int[][] grid){

        int n = grid.length;
        
        boolean[] mSet = new boolean[n];
        int[] key = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        
        key[0] = 0; //for source
        int res = 0;

        for(int count = 0; count<n; count++){ //count from 0 to n-1 for all verices
            int u = -1;
            for(int i=0; i<n; i++){
                if(!mSet[i] && (u==-1 || key[i] < key[u]))
                    u = i;
            }
            
            if(u == -1) return -1; // graph not connected

            //adding vertice of minimum weight to MST
            mSet[u] = true;
            res += key[u];

            //relaxing all adjacent nodes
            for(int v=0; v<n; v++){
                if(!mSet[v] && grid[u][v] > 0 && key[v] > grid[u][v])
                    key[v] = grid[u][v];
            }
        }
        return res;
    }
}
