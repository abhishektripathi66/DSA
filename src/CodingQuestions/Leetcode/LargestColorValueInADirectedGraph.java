/*
1857. Largest Color Value in a Directed Graph
Solved
Hard
Topics
Companies
Hint
There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.

You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.

A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.

Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.

 

Example 1:



Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
Output: 3
Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (red in the above image).
Example 2:



Input: colors = "a", edges = [[0,0]]
Output: -1
Explanation: There is a cycle from 0 to 0.
 

Constraints:

n == colors.length
m == edges.length
1 <= n <= 105
0 <= m <= 105
colors consists of lowercase English letters.
0 <= aj, bj < n
*/

import java.util.ArrayList;

public class LargestColorValueInADirectedGraph {
    private static final int INF = 2000000000;
    private int dfs(int u, String colors, ArrayList<ArrayList<Integer>> adj, int[][] count,  int[] vis){
        if(vis[u] == 1)
            return INF;
        
        if(vis[u] == 2)
            return count[u][colors.charAt(u) - 'a'];
        
        //vis[u] == 0
        vis[u] = 1;
        for(int v : adj.get(u)){
            int res = dfs(v, colors, adj, count, vis);
            if(res == INF)
                return INF;
            
            for(int c = 0; c < 26; c++)
                count[u][c] = Math.max(count[u][c], count[v][c]);
        }
        count[u][colors.charAt(u) - 'a']++;
        vis[u] = 2;
        return count[u][colors.charAt(u) - 'a'];
    }

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int[] e : edges)
            adj.get(e[0]).add(e[1]);
        
        int[][] count = new int[n][26];
        int[] vis = new int[n];
        int res = 0;
        
        for(int i = 0; i < n; i++)
            res = Math.max(res, dfs(i, colors, adj, count, vis));
        
        if(res == INF)
            return -1;
        
        return res;
    }
}
