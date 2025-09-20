package algorithms.dp;

import java.util.Arrays;

/*
* Knapsack Problem Variants (DP and Greedy)
*
* Problem:
*   Given a set of items with weights and values, and a bag with limited capacity,
*   determine the maximum value that can be obtained under different rules.
*
* Types:
*   - 0/1 Knapsack:
*       Each item can be taken at most once (either include or exclude).
*   - Fractional Knapsack:
*       Items can be divided into fractions; take highest value/weight ratio first (Greedy).
*   - Unbounded Knapsack:
*       Each item can be chosen unlimited times (infinite supply).
*   - Multiple Knapsack:
*       Each item has a limited quantity (bounded supply).
*
* Approaches:
*   - 0/1, Unbounded, and Multiple → Dynamic Programming.
*   - Fractional → Greedy strategy.
*
* Time Complexity:
*   - 0/1 Knapsack: O(n * W), where n = items, W = capacity.
*   - Fractional: O(n log n) due to sorting by ratio.
*   - Unbounded & Multiple: O(n * W).
*
*/


//Here, This Class is about 0/1 Knapsack Problem
/*
 * 0/1 Knapsack Problem
 *
 * Problem:
 *   Given 'n' items with values and weights, and a maximum capacity 'W' of the knapsack,
 *   find the maximum total value that can be obtained by selecting a subset of the items.
 *   Each item can either be included (1) or excluded (0) — hence the name 0/1 Knapsack.
 *
 * Approach:
 *   - Memoization (Top-Down):
 *       Recursively decide for each item whether to include it or not,
 *       and store results in a memoization table to avoid recomputation.
 *   - Tabulation (Bottom-Up):
 *       Iteratively build a DP table where dp[i][j] stores the maximum value 
 *       achievable with the first 'i' items and capacity 'j'.
 *
 * Time Complexity:
 *   - O(n * W), where n is the number of items and W is the capacity.
 *
 * Space Complexity:
 *   - O(n * W) for the DP table (can be optimized to O(W) using 1D array).
 *
 * Example:
 *   Input:
 *     val = {10, 40, 30, 50}
 *     wt  = {5, 4, 6, 3}
 *     W = 10
 *
 *   Output:
 *     Max value : 90
 */

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 6, 3};
        int  W = 10;
        int n = val.length;

        int[][] memo = new int[n+1][W+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println("Max value : "+knapsackProblemMemo(W, wt, val, n, memo));
        System.out.println("Max value : "+knapsackProblemTabulation(W, wt, val, n));
    }

    private static int knapsackProblemMemo(int W, int wt[], int val[], int n, int[][] memo){

        //when no items left or no capicity left
        if(n==0 || W == 0)
            return memo[n][W] = 0;
        
        if(memo[n][W] != -1)
            return memo[n][W];

        int pick = 0;
        if(wt[n-1] <= W) //when curr item's weight is less than or equal to remaining capacity
            pick = val[n-1] + knapsackProblemMemo(W - wt[n-1], wt, val, n-1, memo);

        int notPick = knapsackProblemMemo(W, wt, val, n-1, memo); //skip curr item

        return memo[n][W] = Math.max(pick, notPick); //take max from both options
    }

    private static int knapsackProblemTabulation(int W, int wt[], int val[], int n){

         int[][] dp = new int[n+1][W+1]; // dp[i][j] means max value with i items and capacity j

        //optiona but wrote for better clarity
        //when n=0 or W=0 → value = 0
        for(int i=0; i<=n; i++)
            dp[i][0] = 0;   // capacity = 0
        
        for(int j=0; j<=W; j++)
            dp[0][j] = 0;   // no items
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){

                if(wt[i-1] > j)
                    dp[i][j] = dp[i-1][j]; // can’t pick item

                else{
                    int pick = val[i-1] + dp[i-1][j - wt[i-1]];
                    int notPick = dp[i-1][j];
                    dp[i][j] = Math.max(pick, notPick); //take max value from either option
                }
            }
        }

        return dp[n][W];
     }
}
