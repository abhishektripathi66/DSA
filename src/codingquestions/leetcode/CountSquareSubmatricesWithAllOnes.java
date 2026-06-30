package codingquestions.leetcode;

/*
1277. Count Square Submatrices with All Ones
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
*/
class CountSquareSubmatriceswithAllOnes {
    private int sumOfSquares(int[][] dp, int lx, int ly, int rx, int ry){
        return dp[rx][ry] - dp[lx - 1][ry] - dp[rx][ly - 1] + dp[lx - 1][ly - 1];
    }

    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
        
        int res = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                for(int len = 1; i + len - 1 <= m && j + len - 1 <= n; len++){
                    if(sumOfSquares(dp, i, j, i + len - 1, j + len - 1) == len * len)
                        res++;
                    
                    else
                        break;
                }
            }
        }
        return res;
    }
}
