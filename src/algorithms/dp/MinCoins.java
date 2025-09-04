package algorithms.dp;

import java.util.Arrays;

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
        
        if (coins[i] <= sum) {
            take = minCoinsMemo(i, sum - coins[i], coins, memo);
            if (take != Integer.MAX_VALUE) take++;
        }
      
        int noTake = minCoinsMemo(i + 1, sum, coins, memo);
        
        return memo[i][sum] = Math.min(take, noTake);
    }


    private static int minCoinsTabulation(int sum, int[] coins, int n){
        int[][] dp = new int[n+1][sum+1];

        // Base case: sum = 0 requires 0 coins
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // Base case: with no coins, we can't form positive sums
        for (int s = 1; s <= sum; s++) {
            dp[n][s] = Integer.MAX_VALUE;
        }

        // Fill table bottom-up
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
