package algorithms.dp;

import java.util.Arrays;

/*
 * Minimum Coin Change Problem using Memoization and Tabulation
 *
 * Problem:
 *   Given an array of coin denominations and a target sum,
 *   find the minimum number of coins required to make the sum.
 *   Each coin can be used an unlimited number of times.
 *   If it is not possible to form the sum, return -1.
 *
 * Approach:
 *   - Memoization (Top-Down):
 *       Recursively decide whether to include or exclude a coin
 *       and store results in a memoization table to avoid recomputation.
 *   - Tabulation (Bottom-Up):
 *       Build a DP table iteratively where dp[i][s] stores the minimum
 *       number of coins required to make sum 's' using coins[i..n-1].
 *
 * Time Complexity:
 *   - O(n * sum), where n is the number of coins.
 *
 * Space Complexity:
 *   - O(n * sum) for the DP table or memoization matrix.
 *   - Can be optimized to O(sum) using a 1D DP array.
 *
 * Example:
 *   Input:
 *     coins = {3, 4, 1}
 *     sum   = 5
 *
 *   Output:
 *     Min coins required: 2
 *     Explanation: Either {4, 1} or {3, 1, 1}
 */

public class MinCoins {
    public static void main(String[] args) {

        int[] coins = {3, 4, 1};
        int sum = 5;
        int n = coins.length;

        int[][] memo = new int[n+1][sum+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("Min coins required: "+minCoinsMemo(0, sum, coins, memo));
        System.out.println("Min coins required: "+minCoinsTabulation(sum, coins, n));
    }

    private static int minCoinsMemo(int i, int sum, int[] coins, int[][] memo) {

        // base case
        if(sum == 0) 
            return 0;

        if (sum < 0 || i == coins.length) 
            return Integer.MAX_VALUE;
        
        if(memo[i][sum] != -1) 
            return memo[i][sum];
        
        int take = Integer.MAX_VALUE;
        
        if (coins[i] <= sum) { //consider opiton if coin value is less than or equal to curr sum
            take = minCoinsMemo(i, sum - coins[i], coins, memo);
            if (take != Integer.MAX_VALUE) take++;
        }

        //skip curr coin
        int noTake = minCoinsMemo(i + 1, sum, coins, memo);
        
        //choose min from both options
        return memo[i][sum] = Math.min(take, noTake);
    }


    private static int minCoinsTabulation(int sum, int[] coins, int n){
        int[][] dp = new int[n+1][sum+1];

        //sum = 0 requires 0 coins
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        //with no coins, we can't form positive sums
        for (int s = 1; s <= sum; s++) {
            dp[n][s] = Integer.MAX_VALUE;
        }

        //fill table bottom-up
        for (int i = n-1; i >= 0; i--) {
            for (int s = 1; s <= sum; s++) {
                int take = Integer.MAX_VALUE;
                if (coins[i] <= s && dp[i][s - coins[i]] != Integer.MAX_VALUE) {
                    take = 1 + dp[i][s - coins[i]];
                }
                int noTake = dp[i+1][s];
                dp[i][s] = Math.min(take, noTake);
            }
        }

        return dp[0][sum] == Integer.MAX_VALUE ? -1 : dp[0][sum];

    }
}
