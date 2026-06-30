/*
85. Maximal Rectangle
Solved
Hard
Topics
premium lock icon
Companies
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= rows, cols <= 200
matrix[i][j] is '0' or '1'.
*/
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length + 1];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 1; j <= matrix[0].length; j++)
                dp[i][j] = dp[i][j - 1] + (matrix[i][j - 1] - '0');
        
        int res = 0;
        for(int j1 = 1; j1 <= matrix[0].length; j1++){
            for(int j2 = j1; j2 <= matrix[0].length; j2++){
                int last = 0;
                for(int i = 0; i < matrix.length; i++){
                    if(dp[i][j2] - dp[i][j1 - 1] != j2 - j1 + 1){
                        res = Math.max(res, (i - last) * (j2 - j1 + 1));
                        last = i + 1;
                    }
                }
                res = Math.max(res, (matrix.length - last) * (j2 - j1 + 1));
            }
        }
        return res;
    }
}
