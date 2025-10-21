package algorithms.dp;

import java.util.Arrays;


/*
 * Optimal Strategy for a Game
 *
 * You are given an array representing coins arranged in a line, where each coin has a certain value.
 * Two players take turns picking a coin from either end of the line. Both players play optimally
 * to maximize the total value of coins they collect. The goal is to determine the maximum possible
 * value the first player can achieve.
 *
 * Approaches implemented:
 *   1. Recursive Solution
 *      - Time Complexity: O(2^n)
 *      - Space Complexity: O(n) recursion stack
 *   2. Memoization (Top-down DP)
 *      - Time Complexity: O(n^2)
 *      - Space Complexity: O(n^2) for memo table + O(n) recursion stack
 *   3. Tabulation (Bottom-up DP)
 *      - Time Complexity: O(n^2)
 *      - Space Complexity: O(n^2) for DP table
 *
 * Example:
 *   arr = {20, 5, 4, 6}
 *   → Maximum value that first player can collect = 25
 *     (Player 1 picks 20, Player 2 picks 6, Player 1 picks 5, total = 25)
 */

public class OptimalStrategyForGame {
    public static void main(String[] args) {
        //even number of coins will be given
        int[] arr = {20, 5, 4, 6};
        int n = arr.length;

        System.out.println("Maximum value can be collected : "+optimalStrategyRec(arr, 0, n-1));

        int[][] memo = new int[n][n];
        for(int[] row: memo)
            Arrays.fill(row, -1);
        System.out.println("Maximum value can be collected : "+optimalStrategyMemo(arr, 0, n-1, memo));

        System.out.println("Maximum value can be collected : "+optimalStrategyTabulation(arr, n));
    }

    private static int optimalStrategyRec(int[] arr, int i, int j){
        //pointers surpass each other, no coins left
        if(i > j)
            return 0;

        //one coin left
        if(i == j)
            return arr[i];
        
        //when just two coins left
        if( i+1 == j)
            return Math.max(arr[i], arr[j]);
        
        //either we choose arr[i] or arr[j], opponent will choose in a way that we get min value in next moves
        //so we have to take maximum from both options
        return Math.max(arr[i] + Math.min(optimalStrategyRec(arr, i+2, j), optimalStrategyRec(arr, i+1, j-1)), 
        arr[j] + Math.min(optimalStrategyRec(arr, i+1, j-1), optimalStrategyRec(arr, i, j-2)));
    }


    private static int optimalStrategyMemo(int[] arr, int i, int j, int[][] memo){

        //Base cases
        if(i > j)
            return 0;

        if(i == j)
            return arr[i];
        
        if( i+1 == j)
            return Math.max(arr[i], arr[j]);
        
        //already computed then return
        if(memo[i][j] != -1)
            return memo[i][j];
        
        //take max possible outcome and store the result
        return memo[i][j] = Math.max(arr[i] + Math.min(optimalStrategyMemo(arr, i+2, j, memo), optimalStrategyMemo(arr, i+1, j-1, memo)), 
        arr[j] + Math.min(optimalStrategyMemo(arr, i+1, j-1, memo), optimalStrategyMemo(arr, i, j-2, memo)));
    }

     private static int optimalStrategyTabulation(int[] arr, int n) {
        int[][] dp = new int[n][n];

        // Base cases: only one coin
        for (int i = 0; i < n; i++)
            dp[i][i] = arr[i];
        
        // choose max from two given coins
        for(int i=0; i<n-1; i++)
            dp[i][i+1] = Math.max(arr[i], arr[i+1]); 

        // fill the table diagonally
        for (int gap = 2; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {

                // Get values safely (if index out of bounds, use 0)
                int x = (i + 2 <= j) ? dp[i + 2][j] : 0;
                int y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                int z = (i <= j - 2) ? dp[i][j - 2] : 0;
                
                //dp[i][j] = maximum value the current player can collect from arr[i...j].
                dp[i][j] = Math.max(
                    arr[i] + Math.min(x, y),
                    arr[j] + Math.min(y, z)
                );
            }
        }

        return dp[0][n - 1];
    }
}
