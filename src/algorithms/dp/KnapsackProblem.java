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
}
