package algorithms.dp;

import java.util.Arrays;

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
    }

    private static int knapsackProblemMemo(int W, int wt[], int val[], int n, int[][] memo){

        if(n==0 || W == 0)
            return memo[n][W] = 0;
        
        if(memo[n][W] != -1)
            return memo[n][W];

        int pick = 0;
        if(wt[n-1] <= W)
            pick = val[n-1] + knapsackProblemMemo(W - wt[n-1], wt, val, n-1, memo);

        int notPick = knapsackProblemMemo(W, wt, val, n-1, memo);

        return memo[n][W] = Math.max(pick, notPick);
    }

    private static int knapsackProblemTabulation(int W, int wt[], int val[], int n){

         int[][] dp = new int[n+1][W+1];

         for(int i=0; i<=n; i++)
            dp[i][0] = 0;
        
        for(int j=0; j<=W; j++)
            dp[0][j] = 0;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){

                if(wt[i-1] > j)
                    dp[i][j] = dp[i-1][j]; // can’t pick item

                else 
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j - wt[i-1]], dp[i-1][j]);
            }
        }

        return dp[n][W];
     }
}
