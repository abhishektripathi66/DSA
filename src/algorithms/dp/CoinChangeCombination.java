package algorithms.dp;

import java.util.Arrays;

public class CoinChangeCombination {
    public static void main(String[] args) {
        
        int sum = 5;
        int[] coins = {1, 2, 3};
        int n = coins.length;

        int[][] memo = new int[n+1][sum+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        
        System.out.println("Number of combination : "+coinChangeCombinationMemo(n-1, sum, coins, memo));
    }

    private static int coinChangeCombinationMemo(int idx, int currSum, int[] coins, int[][] memo){
        if(idx < 0)
            return 0;
        
        if(memo[idx][currSum] != -1)
            return memo[idx][currSum];
        
        if(currSum == 0)
            return memo[idx][currSum] = 1;
        
        int count = coinChangeCombinationMemo(idx-1, currSum, coins, memo); //skip current coin
        if(coins[idx] <= currSum)
            count += coinChangeCombinationMemo(idx, currSum - coins[idx], coins, memo); //take current coin
        
        return memo[idx][currSum] = count;
    }
}
