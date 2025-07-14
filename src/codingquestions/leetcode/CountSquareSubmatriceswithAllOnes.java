/**
 * 1277. Count Square Submatrices with All Ones
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 **/
public class CountSquareSubmatriceswithAllOnes {
    public int countSquares(int[][] matrix) {
        // Get dimensions of the matrix
        int n = matrix.length;    // number of rows
        int m = matrix[0].length; // number of columns

        // Create a DP table with same dimensions as matrix
        int[][] dp = new int[n][m];

        // Variable to store total count of squares
        int ans = 0;

        // Initialize first column of DP table
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
            ans += dp[i][0];
        }

        // Initialize first row of DP table
        for (int j = 1; j < m; j++) {
            dp[0][j] = matrix[0][j];
            ans += dp[0][j];
        }

        // Fill the DP table for remaining cells
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
                ans += dp[i][j];
            }
        }

        return ans;
    }
}

