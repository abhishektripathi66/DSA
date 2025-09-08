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

        memo = new int[n+1][sum+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        System.out.println("Min coins required: "+minCoinsMemo1(sum, coins, memo, n));
        System.out.println("Min coins required: "+minCoinsTabulation1(sum, coins, n));
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
            //take = minCoinsMemo(i+1, sum - coins[i], coins, memo); //0/1 coin version
            take = minCoinsMemo(i, sum - coins[i], coins, memo); //unlimited coins
            if (take != Integer.MAX_VALUE) 
                take++; //because we have used current coin
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
        for (int j = 1; j <= sum; j++) {
            dp[n][j] = Integer.MAX_VALUE;
        }

        //fill table bottom-up
        for (int i = n-1; i >= 0; i--) {
            for (int j = 1; j <= sum; j++) {
                int take = Integer.MAX_VALUE;
                if (coins[i] <= j && dp[i][j - coins[i]] != Integer.MAX_VALUE) {
                    //take = 1 + dp[i+1][j - coins[i]]; //0/1 coin version
                    take = 1 + dp[i][j - coins[i]]; //unlimited coins
                }
                int noTake = dp[i+1][j];
                dp[i][j] = Math.min(take, noTake);
            }
        }

        return dp[0][sum] == Integer.MAX_VALUE ? -1 : dp[0][sum];

    }
    
    //Other way to implement memoization and tabulation methods, the way did in previous dp problems
    //going from n to 0 in memoization
    //and from 0 to n in tabulation
    private static int minCoinsMemo1(int sum, int[] coins, int[][] memo, int n) {

        if(sum == 0)
            return 0;
        
        if(n==0 || sum < 0)
            return Integer.MAX_VALUE;
        
        if(memo[n][sum] != -1)
            return memo[n][sum];
    
        int take = Integer.MAX_VALUE;
        if(coins[n-1] <= sum){
            //take = minCoinsMemo1(sum - coins[n-1], coins, memo, n-1); //0/1 coin version
            take = minCoinsMemo1(sum - coins[n-1], coins, memo, n);  //unlimited coins
            if (take != Integer.MAX_VALUE) 
                take++; 
        }

        int notTake =  minCoinsMemo1(sum, coins, memo, n-1);
        
        return memo[n][sum] = Math.min(take, notTake);
    }

    private static int minCoinsTabulation1(int sum, int[] coins, int n){
        int[][] dp = new int[n+1][sum+1];

        //when sum is 0
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }

        //when sum is > 0 and no coins left
        for(int j=1; j<=sum; j++){
            dp[0][j] = Integer.MAX_VALUE;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                int take = Integer.MAX_VALUE;
                if(coins[i-1] <= j && dp[i][j - coins[i-1]] != Integer.MAX_VALUE){
                    //take = 1 + dp[i-1][j - coins[i-1]];  //0/1 coin version
                    take = 1 + dp[i][j - coins[i-1]];  //unlimited coins
                }

                int notTake = dp[i-1][j];
                dp[i][j] = Math.min(take, notTake);
            }
        }
        return dp[n][sum];
    }

}
