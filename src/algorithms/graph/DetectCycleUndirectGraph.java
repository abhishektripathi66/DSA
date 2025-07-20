package algorithms.graph;

import java.util.ArrayList;

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
