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
 *   - O(n * sum) for Take/NotTake, where n is the number of coins.
 *   - O(n^2 * sum) for Loop-based approach
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

/*
 * Minimum Coin Change Problem
 *
 * Problem:
 *   Given an array of coin denominations and a target sum,
 *   find the minimum number of coins required to make the sum.
 *   Each coin can be used an unlimited number of times.
 *   Return -1 if the sum cannot be formed.
 *
 * 1-D dp Approaches:
 *   1. Memoization (Top-Down):
 *      Use recursion with caching where dp[s] represents the
 *      minimum coins needed to form sum 's'.
 *
 *   2. Tabulation (Bottom-Up):
 *      Build a DP array iteratively where dp[s] stores the
 *      minimum number of coins required to make sum 's'.
 * 
 *   3. Memoization / Tabulation using 2-D DP:
 *      Use a DP table where dp[i][s] represents the minimum
 *      number of coins required to make sum 's' using coins
 *      from index i to n-1. 
 *
 * Time Complexity:
 *   - O(n * sum), where n is the number of coins.
 *
 * Space Complexity:
 *   - O(sum) using optimized 1-D DP.
 *   - O(n * sum) when using a 2-D DP table.
 *
 * Example:
 *   Input:
 *     coins = {3, 4, 1}, sum = 5
 *
 *   Output:
 *     2  (using coins {4,1} or {3,1,1})
 */

/*
 * Note: Here, 1-D dp can be used instead of 2-D dp because index or order of the coins does not matter.
 *  - 1-D dp is Used in problems like:
 *       • Coin Change (unlimited coins)
 *       • Unbounded Knapsack
 *       • Rod Cutting
 * 
 *  - 1-D dp used in problems like:
 *       • 0/1 Knapsack
 *       • Subset Sum
 *       • Coin Change (for explanation/learning)
 */

public class MinCoins {
    public static void main(String[] args) {

        int[] coins = {3, 4, 1};
        int sum = 5;
        int n = coins.length;

        System.out.println("In Following implemetations 1-D dp is used:");
        int[] memo1D = new int[sum + 1];
        Arrays.fill(memo1D, -1);

        int ans = minCoinsMemo1D(sum, coins, memo1D);
        System.out.println("Min coins required: "+ (ans == Integer.MAX_VALUE ? -1 : ans));
        System.out.println("Min coins required: "+minCoinsTabulation1D(coins, sum) );


        System.out.println("\nIn Following implemetations 2-D dp is used:");
        int[][] memo = new int[n+1][sum+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("Min coins required: "+minCoinsMemo(0, sum, coins, memo));
        System.out.println("Min coins required: "+minCoinsTabulation(sum, coins, n));

        System.out.println("\nAlternative way to implement both methods : ");
        memo = new int[n+1][sum+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        System.out.println("Min coins required: "+minCoinsMemo1(sum, coins, memo, n));
        System.out.println("Min coins required: "+minCoinsTabulation1(sum, coins, n));

        System.out.println("\nLoop based approach : ");
        memo = new int[n+1][sum+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        System.out.println("Min coins required: "+minCoinsLoopMemo(0, sum, coins, memo));
        System.out.println("Min coins required: "+minCoinsLoopTab(coins, sum));
    }

    private static int minCoinsMemo1D(int sum, int[] coins, int[] memo) {

        if(sum == 0)
            return 0;

        if(sum < 0)
            return Integer.MAX_VALUE;

        if(memo[sum] != -1)
            return memo[sum];

        int min = Integer.MAX_VALUE;

        for(int coin : coins) {
            if(coin <= sum) {
                //if currSum  - currCoin amount is achievable
                //consider that option and get the minimum value among all options 
                int sub = minCoinsMemo1D(sum - coin, coins, memo);
                if(sub != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + sub);
                }
            }
        }

        return memo[sum] = min;
    }

    private static int minCoinsTabulation1D(int[] coins, int sum) {

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int coin : coins) {
            for(int s = coin; s <= sum; s++) {
                //if s-coin[i] amount consist valid answer
                if(dp[s - coin] != Integer.MAX_VALUE) {  
                    dp[s] = Math.min(dp[s], 1 + dp[s - coin]);
                }
            }
        }

        return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
    }

    private static int minCoinsMemo(int i, int sum, int[] coins, int[][] memo) {

        //base case
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


    //Loop-based approach (N-ary recursion tree)
    //Time complexity = O(n * sum * n) in the worst case (because inside each state we loop over up to n coins).
    private static int minCoinsLoopMemo(int idx, int sum, int[] coins, int[][] memo) {
        if(sum == 0) 
            return 0;
        
        if(idx == coins.length) 
            return Integer.MAX_VALUE;

        if(memo[idx][sum] != -1) 
            return memo[idx][sum];

        int res = Integer.MAX_VALUE;

        //try all coins starting from current index
        for(int i = idx; i < coins.length; i++) {
            if(coins[i] <= sum) {
                int sub = minCoinsLoopMemo(i, sum - coins[i], coins, memo); // reuse i
                if(sub != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + sub);
                }
            }
        }
        return memo[idx][sum] = res;
    }

    private static int minCoinsLoopTab(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];

        //no coins left, but sum still > 0 → impossible
        for(int j = 1; j <= sum; j++) {
            dp[n][j] = Integer.MAX_VALUE;
        }

        //0 coins needed to make sum = 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        //fill DP table bottom-up
        for (int i = n - 1; i >= 0; i--) {            // from last coin to first
            for (int j = 1; j <= sum; j++) {          // for every sum
                int res = Integer.MAX_VALUE;

                // try all coins starting at index i
                for (int k = i; k < n; k++) {
                    if (coins[k] <= j && dp[k][j - coins[k]] != Integer.MAX_VALUE) {
                        res = Math.min(res, 1 + dp[k][j - coins[k]]);
                    }
                }

                dp[i][j] = res;
            }
        }

        //answer is dp[0][sum]
        return dp[0][sum] == Integer.MAX_VALUE ? -1 : dp[0][sum];
    }


}
