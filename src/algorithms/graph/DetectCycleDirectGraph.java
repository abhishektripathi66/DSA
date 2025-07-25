package algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectGraph {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 0},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 0}};
        
         
        ArrayList<ArrayList<Integer>> adj = convertGridIntoAdjList(grid);

        if(BFSUtil(adj))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph does not contain cycle");
    }

    private static boolean BFSUtil(ArrayList<ArrayList<Integer>>  adj){
        int n = adj.size();

        int[] indegree = new int[n];
        for(int i=0; i<n; i++){

            for(int v : adj.get(i))
                indegree[v]++;
            
            //can not be used with adj but used with grid
            // for(int j=0; j<n; j++){
            //     if(adj.get(i).get(j) == 1)
            //         indegree[j]++;
            // }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            
            int u = q.poll();
            count++;

            for(int v : adj.get(u)){
                indegree[v] --;
                if(indegree[v] == 0)
                    q.add(v);
            }

        }

        return count!=n;
    }


    private static boolean DFSUtil(int u, ArrayList<ArrayList<Integer>>  adj, boolean[] visited, boolean[] recSt){
        visited[u] = true;

        for(int v : adj.get(u)){
            if(!visited[v])
                if(DFSUtil(v, adj, visited, recSt))
                    return true;
            else if(recSt[v])
                return true;
        }
        recSt[u] = false;
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
