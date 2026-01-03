/*
1411. Number of Ways to Paint N × 3 Grid
Solved
Hard
Topics
premium lock icon
Companies
Hint
You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colors: Red, Yellow, or Green while making sure that no two adjacent cells have the same color (i.e., no two cells that share vertical or horizontal sides have the same color).

Given n the number of rows of the grid, return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo 109 + 7.

 

Example 1:


Input: n = 1
Output: 12
Explanation: There are 12 possible way to paint the grid as shown.
Example 2:

Input: n = 5000
Output: 30228214
 

Constraints:

n == grid.length
1 <= n <= 5000
*/
class Solution {
    private List<int[]> createCombinations(){
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == j)
                    continue;
                for(int k = 0; k < 3; k++){
                    if(j != k)
                        res.add(new int[]{i, j, k});
                }
            }
        }
        return res;
    }

    public int numOfWays(int n) {
        int[][][][] dp = new int[n][3][3][3];
        List<int[]> combinations = createCombinations();
        for(int[] i : combinations)
            dp[0][i[0]][i[1]][i[2]] = 1;

        int MOD = (int)1e9 + 7;
        for(int i = 1; i < n; i++){
            for(int[] cur : combinations){
                for(int[] prev : combinations){
                    if(prev[0] != cur[0] && prev[1] != cur[1] && prev[2] != cur[2]){
                        dp[i][cur[0]][cur[1]][cur[2]] = (dp[i][cur[0]][cur[1]][cur[2]] 
                        + dp[i - 1][prev[0]][prev[1]][prev[2]]) % MOD;
                    }
                }
            }
        }

        int res = 0;
        for(int[] i : combinations)
            res = (res + dp[n - 1][i[0]][i[1]][i[2]]) % MOD;
        
        return res;
    }
}
