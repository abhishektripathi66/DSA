package algorithms.graph;

import java.util.Arrays;

public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 2, 3},
            {2, 0, 1},
            {3, 1, 0}
        };

        int source = 0;
        int[] dist = dijkstrasAlgorithmGrid(grid, source);

        if(dist != null){
            System.out.println("Shorted distance for all the vertices from the source : "+source);
            for(int v=0; v<dist.length; v++){
                System.out.println("vertice:"+v+", distance:"+dist[v]);
            }
        }
        else{
            System.out.println("graph is not connected, so shortest paths for all vertices can not be computed");
        }
        
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
            
            if(u == -1)  //disconnected graph
                return null;

            fin[u] = true; //finalize selected min-distant vertice
            
            //traverse all adjacent vertices of the current node
            for(int v=0; v<n; v++){
                //if not finalized and there is a shorter path to v through u
                if(!fin[v] && grid[u][v]>0 && dist[v] > dist[u] + grid[u][v])
                    dist[v] = dist[u] + grid[u][v];
            }
        }

        return dist;
    }
}
