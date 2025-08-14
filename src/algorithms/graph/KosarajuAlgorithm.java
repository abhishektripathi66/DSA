package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosarajuAlgorithm {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0}
        };
        
        //fist get the list of vertices inn decreasing order of finish time          
        ArrayList<ArrayList<Integer>>  adj = convertGridIntoAdjList(grid);
        boolean[] visited = new boolean[grid.length];
        Stack<Integer> st = new Stack<>();
        //DFSTopoloicalSort(0, adj, visited, st);
        for (int i = 0; i < grid.length; i++) {
            if (!visited[i]) {
                DFSOrderList(i, adj, visited, st);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!st.isEmpty()){
            list.add(st.pop());
        }

        
        //reverse the edges
        ArrayList<ArrayList<Integer>>  revAdj = convertGridIntoRevAdjList(grid);

        //run DFS again on retrieved list because strongly connectded componet will stay connected in same way
        Arrays.fill(visited, false);
        for(int i=0; i<list.size(); i++){
            if(!visited[list.get(i)]){
                System.out.print("Strongly connected component from "+list.get(i)+" : ");
                dfsTraversal(list.get(i), revAdj, visited);
                System.out.println();
            }
        }
        
    }

    private static void dfsTraversal(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");
        for (int v : adj.get(u)) {
            if (!visited[v])
                dfsTraversal(v, adj, visited);
        }
    }

    public static void DFSOrderList(int u, ArrayList<ArrayList<Integer>>  adj, boolean[] visited, Stack<Integer> st){
        visited[u] = true;

        for(int v : adj.get(u)){
            if(!visited[v])
                DFSOrderList(v, adj, visited, st);
        }

        st.push(u);
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

    private static ArrayList<ArrayList<Integer>> convertGridIntoRevAdjList(int[][] grid) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        //create all empty adjacency lists first
        for (int i = 0; i < grid.length; i++) {
            adj.add(new ArrayList<>());
        }

        //now add reversed edges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    adj.get(j).add(i); // reverse edge
            }
        }
        return adj;
    }
}
