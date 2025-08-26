package codingquestions.leetcode;

/*
1504. Count Submatrices With All Ones
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an m x n binary matrix mat, return the number of submatrices that have all ones.

 

Example 1:


Input: mat = [[1,0,1],[1,1,0],[1,1,0]]
Output: 13
Explanation: 
There are 6 rectangles of side 1x1.
There are 2 rectangles of side 1x2.
There are 3 rectangles of side 2x1.
There is 1 rectangle of side 2x2. 
There is 1 rectangle of side 3x1.
Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
Example 2:


Input: mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]
Output: 24
Explanation: 
There are 8 rectangles of side 1x1.
There are 5 rectangles of side 1x2.
There are 2 rectangles of side 1x3. 
There are 4 rectangles of side 2x1.
There are 2 rectangles of side 2x2. 
There are 2 rectangles of side 3x1. 
There is 1 rectangle of side 3x2. 
Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
 

Constraints:

1 <= m, n <= 150
mat[i][j] is either 0 or 1.
*/
class CountSubmatricesWithAllOnes {
    private int prefixSum(int[][] dp, int i, int j, int ii, int jj){
        return dp[ii][jj] - dp[i - 1][jj] - dp[ii][j - 1] + dp[i - 1][j - 1];
    }

    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;

        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                for(int ii = i; ii <= m; ii++){
                    if(prefixSum(dp, i, j, ii, j) != ii - i + 1)
                        break;
                    
                    int jj = j;
                    int l = j, r = n, mid;
                    while(l <= r){
                        mid = (l + r) >> 1;
                        if(prefixSum(dp, i, j, ii, mid) == (ii - i + 1) * (mid - j + 1)){
                            jj = mid;
                            l = mid + 1;
                        }
                        else
                            r = mid - 1;
                    }
                    res += (jj - j + 1);
                }
            }
        }
        return res;
    }
}
