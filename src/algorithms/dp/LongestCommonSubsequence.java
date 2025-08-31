package algorithms.dp;

import java.util.Arrays;

/*
 * Longest Common Subsequence (LCS) using Memoization and Tabulation
 *
 * Problem:
 *   Given two strings, find the length of their Longest Common Subsequence (LCS).
 *   A subsequence is a sequence that appears in the same relative order,
 *   but not necessarily contiguous.
 *
 * Approach:
 *   - Memoization (Top-Down):
 *       Recursively compare characters from the end of both strings and
 *       store results in a memoization table to avoid recomputation.
 *   - Tabulation (Bottom-Up):
 *       Build a DP table iteratively where dp[i][j] stores the LCS length
 *       of prefixes s1[0..i-1] and s2[0..j-1].
 *   - Reconstruction:
 *       Backtrack from dp[m][n] to rebuild the actual LCS string.
 *
 * Time Complexity:
 *   - O(m * n), where m and n are the lengths of the two strings.
 *
 * Space Complexity:
 *   - O(m * n) for the DP table or memoization matrix.
 *
 * Example:
 *   Input:
 *     s1 = "AXYZ"
 *     s2 = "BAZ"
 *
 *   Output:
 *     LCS length : 2
 *     LCS string : "AZ"
 */

public class LongestCommonSubsequence {
    public static void main(String[] args){
        String s1 = "AXYZ";
        String s2 = "BAZ";
        int m = s1.length();
        int n = s2.length();

        int[][] memo = new int[m+1][n+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        
        System.out.println("LCS : "+longestCommonSubsequenceMemo(s1, s2, m, n, memo));//2 for 'AZ'

        int[][] dp = longestCommonSubsequenceTabulation(s1, s2, m, n);
        System.out.println("LCS : "+dp[m][n]);

        //memo table can't be used here as it might have -1 at some places
        //we rely on both dp[i-1][j] and dp[i][j-1] being valid numbers and in tabulation table they always are
        //System.out.println("LCS String: " + reconstructLCS(s1, s2, memo));\

        System.out.println("LCS String: " + reconstructLCS(s1, s2, dp));
    }

    private static int longestCommonSubsequenceMemo(String s1, String s2, int m, int n, int[][] memo){
 
        //for any of the empty string it will be zero
        if(m==0 || n==0)
            return  memo[m][n] = 0;
        
        //if result already computed, return it
        if(memo[m][n] != -1)
            return memo[m][n];
        
        //if matched, then consider that character in LCS
        if(s1.charAt(m-1) == s2.charAt(n-1))
            return memo[m][n] = 1 + longestCommonSubsequenceMemo(s1, s2, m-1, n-1, memo);
        else //otherwise, take max value by going backward in S1 or S2
            return memo[m][n] = Math.max(longestCommonSubsequenceMemo(s1, s2, m-1, n, memo), longestCommonSubsequenceMemo(s1, s2, m, n-1, memo));
        
    }

    private static int[][] longestCommonSubsequenceTabulation(String s1, String s2,  int m, int n){
        int[][] dp = new int[m+1][n+1];

        //optional, wrote just for understanding that for any empty string LCS is empty
        for(int i=0; i<=m; i++)
            dp[i][0] = 0;
        for(int j=0; j<=n; j++)
            dp[0][j] = 0;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) //match
                    dp[i][j] = 1 + dp[i-1][j-1];
                else//not mathced, take max from two choices
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        //return dp[m][n];
        return dp; //need dp table for reconstruction of LCS
    }

    //Reconstructing LCS string
    private static String reconstructLCS(String s1, String s2, int[][] dp){
        int i = s1.length();
        int j = s2.length();
        StringBuilder lcs = new StringBuilder();

        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                //whenever characters are matched, add that in LCS String and go diagonally backward
                lcs.append(s1.charAt(i-1));
                i--;
                j--;
            }
            //if not match, go backward which has max value like the same way done while computing dp array
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString(); //reverse as LCS is built from backside
    }
}
