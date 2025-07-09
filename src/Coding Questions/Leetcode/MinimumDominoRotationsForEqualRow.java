/*
1007. Minimum Domino Rotations For Equal Row
Solved
Medium
Topics
Companies
In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.

If it cannot be done, return -1.

 

Example 1:


Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
Example 2:

Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
 

Constraints:

2 <= tops.length <= 2 * 104
bottoms.length == tops.length
1 <= tops[i], bottoms[i] <= 6
*/
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int[][] dp = new int[6][n + 4];
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 6; j++) dp[j][i] = 1000000000;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 6; j++){
                if(dp[j][i] == 1000000000)
                    continue;
                
                if(tops[i] - 1 == j)
                    dp[j][i + 1] = Math.min(dp[j][i + 1], dp[j][i]);
                
                else if(bottoms[i] - 1 == j){
                    dp[j][i + 1] = Math.min(dp[j][i + 1], dp[j][i] + 1);
                }
            }
        }
        int res1 = Math.min(dp[bottoms[n - 1] - 1][n], dp[tops[n - 1] - 1][n]);

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 6; j++) dp[j][i] = 1000000000;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 6; j++){
                if(dp[j][i] == 1000000000)
                    continue;
                
                if(bottoms[i] - 1 == j)
                    dp[j][i + 1] = Math.min(dp[j][i + 1], dp[j][i]);
                
                else if(tops[i] - 1 == j){
                    dp[j][i + 1] = Math.min(dp[j][i + 1], dp[j][i] + 1);
                }
            }
        }
        int res2 = Math.min(dp[bottoms[n - 1] - 1][n], dp[tops[n - 1] - 1][n]);

        int res = Math.min(res1, res2);
        if(res == 1000000000)
            res = -1;
        
        return res;
    }
}
