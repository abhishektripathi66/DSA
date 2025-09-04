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
}
