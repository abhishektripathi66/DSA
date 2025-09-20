package algorithms.dp;

import java.util.Arrays;


/*
 * Edit Distance Problem (Levenshtein Distance)
 *
 * Given two strings s1 and s2, the task is to find the minimum number of operations 
 * required to convert s1 into s2. The allowed operations are:
 *   1. Insert a character
 *   2. Delete a character
 *   3. Replace a character
 *
 * Approaches Implemented:
 *   1. Top-Down Dynamic Programming (Memoization)
 *   2. Bottom-Up Dynamic Programming (Tabulation)
 *
 * Time Complexity:
 *   - O(m * n), where m = length of s1 and n = length of s2
 *
 * Space Complexity:
 *   - O(m * n) for the DP table
 *   - O(m * n) recursion stack + memo table in memoization
 *   - Can be optimized to O(min(m, n)) space using only two rows in tabulation
 *
 * Example:
 *   Input:
 *     s1 = "SATURDAY"
 *     s2 = "SUNDAY"
 *
 *   Output:
 *     Minimum edits required to convert S1 to S2 : 3
 *       (Delete 'A', Delete 'T', Replace 'R' with 'N')
 */

public class EditDistance {
    public static void main(String[] args){
        String s1 = "SATURDAY";
        String s2 = "SUNDAY";

        int m = s1.length();
        int n = s2.length();

        int[][] memo = new int[m+1][n+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        
        System.out.println("Minimum edits required to convert S1 to S2 : " +editDistanceMemo(s1, s2, m, n, memo));
        System.out.println("Minimum edits required to convert S1 to S2 : " +editDistanceTabulation(s1, s2, m, n));

    }

    private static int editDistanceMemo(String s1, String s2, int m, int n, int[][] memo){

        if(memo[m][n] != -1)
            return memo[m][n];

        if(m == 0)
            return memo[m][n] = n;
        
        if(n == 0)
            return memo[m][n] = m;
        
        
        if(s1.charAt(m-1) == s2.charAt(n-1)) //if same character, we don't have to perform any operation
            return memo[m][n] = editDistanceMemo(s1, s2, m-1, n-1, memo);
        else{ //otherwise take the min from insert, delete, replace add +1 for action taken
            int insert = editDistanceMemo(s1, s2, m, n-1, memo);
            int delete = editDistanceMemo(s1, s2, m-1, n, memo);
            int replace = editDistanceMemo(s1, s2, m-1, n-1, memo);
            return memo[m][n] = 1 + Math.min(insert, Math.min(delete, replace));
        }
    }

    private static int editDistanceTabulation(String s1, String s2, int m, int n){

        int[][] dp = new int[m+1][n+1];

        // if one string is empty, the number of edits = length of the other string
        for(int i=0; i<=m; i++)
            dp[i][0] = i;
        for(int j=0; j<=n; j++)
            dp[0][j] = j;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){ //if same character, no operation required
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    //otherwise, take minimum from insert, delete , and replace and +1 for the edit made
                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[m][n];
    }
}
