package codingquestions.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2322. Minimum Score After Removals on a Tree
Solved
Hard
Topics
premium lock icon
Companies
Hint
There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given a 0-indexed integer array nums of length n where nums[i] represents the value of the ith node. You are also given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

Remove two distinct edges of the tree to form three connected components. For a pair of removed edges, the following steps are defined:

Get the XOR of all the values of the nodes for each of the three components respectively.
The difference between the largest XOR value and the smallest XOR value is the score of the pair.
For example, say the three components have the node values: [4,5,7], [1,9], and [3,3,3]. The three XOR values are 4 ^ 5 ^ 7 = 6, 1 ^ 9 = 8, and 3 ^ 3 ^ 3 = 3. The largest XOR value is 8 and the smallest XOR value is 3. The score is then 8 - 3 = 5.
Return the minimum score of any possible pair of edge removals on the given tree.

 

Example 1:


Input: nums = [1,5,5,4,11], edges = [[0,1],[1,2],[1,3],[3,4]]
Output: 9
Explanation: The diagram above shows a way to make a pair of removals.
- The 1st component has nodes [1,3,4] with values [5,4,11]. Its XOR value is 5 ^ 4 ^ 11 = 10.
- The 2nd component has node [0] with value [1]. Its XOR value is 1 = 1.
- The 3rd component has node [2] with value [5]. Its XOR value is 5 = 5.
The score is the difference between the largest and smallest XOR value which is 10 - 1 = 9.
It can be shown that no other pair of removals will obtain a smaller score than 9.
Example 2:


Input: nums = [5,5,2,4,4,2], edges = [[0,1],[1,2],[5,2],[4,3],[1,3]]
Output: 0
Explanation: The diagram above shows a way to make a pair of removals.
- The 1st component has nodes [3,4] with values [4,4]. Its XOR value is 4 ^ 4 = 0.
- The 2nd component has nodes [1,0] with values [5,5]. Its XOR value is 5 ^ 5 = 0.
- The 3rd component has nodes [2,5] with values [2,2]. Its XOR value is 2 ^ 2 = 0.
The score is the difference between the largest and smallest XOR value which is 0 - 0 = 0.
We cannot obtain a smaller score than 0.
 

Constraints:

n == nums.length
3 <= n <= 1000
1 <= nums[i] <= 108
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
edges represents a valid tree.

 */
public class MinimumScoreAfterRemovalsonaTree {
    
    // to store the result in the global level
     static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        
    }

   
    // Solution 1
    public int minimumScore(int[] nums, int[][] edges) {
        int n= nums.length;
        List<Integer>[] adj =new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        //0-1
        for(int[] e:edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int[] pXors=nums.clone();
        //performing the dfs and bit manipulation
        calculateXors(0,-1,adj,pXors);

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0]=true;
        int ans=Integer.MAX_VALUE;
        //performing the bfs
        while(!queue.isEmpty()){
            int v = queue.poll();

            for(int u:adj[v]){
                if(!visited[u]){
                    visited[u]=true;
                    queue.offer(u);
                    int firstXor = pXors[u];
                    int remainingxor = pXors[0]^firstXor;
                    calculate(v,u, nums, firstXor, remainingxor,adj);
                    ans = Math.min(ans,result);
                }
            }
        }
        return ans;

    }

    // calculating the min and max of all the xor and then calculating the difference and storing in the result.
    private static int calculate(int v, int parent, int[] nums,int firstXor,int remainingXor,List<Integer>[] adj){
        int currentXor = nums[v];
        for(int child:adj[v]){
            if(child!=parent){
               int childXor= calculate(child,v,nums,firstXor,remainingXor,adj);
               currentXor^=childXor;
               int thirdPart = remainingXor^childXor;
               int max = Math.max(firstXor, Math.max(childXor,thirdPart));
               int min = Math.min(firstXor, Math.min(childXor, thirdPart));
               result= Math.min(result,max-min);
            }
        }
        return currentXor;
    }

    // find the xors of all the child nodes  and storing it in the pxors variable, the parent node has the xor node of the child node.
    private void calculateXors(int node, int parent,List<Integer>[] adj,int[] pXors){
            for(int child:adj[node]){
                if(child!=parent){
                calculateXors(child,node,adj,pXors);
                pXors[node]^= pXors[child];
                }
            }
    }

    // solution 2
     public static int minimumScoreEfficient(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] sum = new int[n];
        int[] in = new int[n];
        int[] out = new int[n];
        int[] cnt = { 0 };

        dfs(0, -1, nums, adj, sum, in, out, cnt);
        int res = Integer.MAX_VALUE;
        for (int u = 1; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                if (in[v] > in[u] && in[v] < out[u]) {
                    res = Math.min(
                        res,
                        calc(sum[0] ^ sum[u], sum[u] ^ sum[v], sum[v])
                    );
                } else if (in[u] > in[v] && in[u] < out[v]) {
                    res = Math.min(
                        res,
                        calc(sum[0] ^ sum[v], sum[v] ^ sum[u], sum[u])
                    );
                } else {
                    res = Math.min(
                        res,
                        calc(sum[0] ^ sum[u] ^ sum[v], sum[u], sum[v])
                    );
                }
            }
        }
        return res;
    }

    private static int calc(int part1, int part2, int part3) {
        return (
            Math.max(part1, Math.max(part2, part3)) -
            Math.min(part1, Math.min(part2, part3))
        );
    }

    private static void dfs(
        int x,
        int fa,
        int[] nums,
        List<List<Integer>> adj,
        int[] sum,
        int[] in,
        int[] out,
        int[] cnt
    ) {
        in[x] = cnt[0]++;
        sum[x] = nums[x];
        for (int y : adj.get(x)) {
            if (y == fa) {
                continue;
            }
            dfs(y, x, nums, adj, sum, in, out, cnt);
            sum[x] ^= sum[y];
        }
        out[x] = cnt[0];
    }
}
