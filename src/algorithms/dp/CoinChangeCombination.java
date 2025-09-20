package algorithms.dp;

import java.util.Arrays;

//Similar to unbounded knapsack

/*
 * Coin Change Combination
 *
 * Problem:
 *   Given a set of coins of different denominations and a total sum,
 *   find the number of distinct combinations of coins that make up the sum.
 *   A combination means order of coins does not matter
 *   (e.g., {2,3} and {3,2} are considered the same).
 *
 * Approach:
 *   - Memoization (Top-Down):
 *       Recursively decide whether to include or exclude the current coin,
 *       and store intermediate results in a memoization table to avoid recomputation.
 *   - Tabulation (Bottom-Up):
 *       Build a DP table iteratively where dp[i][j] represents the number of ways
 *       to make sum j using the first i coins.
 *   - Optimization:
 *       The DP solution can be further optimized to a 1D array of size (sum+1),
 *       reducing space complexity.
 *
 * Time Complexity:
 *   - O(n * sum), where n is the number of coins and sum is the target amount.
 *
 * Space Complexity:
 *   - O(n * sum) for the DP table or memoization matrix.
 *   - Can be optimized to O(sum) using a 1D DP array.
 *
 * Example:
 *   Input:
 *     coins = {1, 2, 3}
 *     sum = 5
 *
 *   Output:
 *     Number of combinations : 5
 *     Combinations are:
 *       1+1+1+1+1
 *       1+1+1+2
 *       1+2+2
 *       1+1+3
 *       2+3
 */

public class CoinChangeCombination {
    public static void main(String[] args) {
        
        int sum = 5;
        int[] coins = {1, 2, 3};
        int n = coins.length;

        int[][] memo = new int[n+1][sum+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        
        System.out.println("Number of combination : "+coinChangeCombinationMemo(n-1, sum, coins, memo));
        System.out.println("Number of combination : "+coinChangeCombinationTabulation(sum, coins, n));
    }

    private static int coinChangeCombinationMemo(int idx, int currSum, int[] coins, int[][] memo){
        if(idx < 0)
            return 0;
        
        //result already calculated, return it
        if(memo[idx][currSum] != -1)
            return memo[idx][currSum];
        
        //otherwise check for currSum and remaining coins

        //when sum value is achieved, store 1 for current combination
        if(currSum == 0)
            return memo[idx][currSum] = 1;
        
        
        int count = coinChangeCombinationMemo(idx-1, currSum, coins, memo); //skip current coin
        if(coins[idx] <= currSum)
            count += coinChangeCombinationMemo(idx, currSum - coins[idx], coins, memo); //take current coin
        
        return memo[idx][currSum] = count;
    }

    private static int coinChangeCombinationTabulation(int sum, int[] coins, int n){
        int[][] dp = new int[n+1][sum+1];
        
        //intialize to 1 when sum is 0
        for(int i=0; i<=n; i++)
            dp[i][0] = 1;
        
        //assign 0 to first row as there is sum>0 and there isn't any coin, except sum equals to 0
        for(int j=1; j<=sum; j++)
            dp[0][j] = 0;
        
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                dp[i][j] = dp[i-1][j]; // exclude current coin
                if(coins[i-1] <= j)
                    dp[i][j] += dp[i][j - coins[i-1]];  // include current coin (stay at i)
            }
        }
    
        return dp[n][sum];
    }
}
