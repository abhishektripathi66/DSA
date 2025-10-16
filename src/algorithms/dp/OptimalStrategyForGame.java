package algorithms.dp;

import java.util.Arrays;

public class OptimalStrategyForGame {
    public static void main(String[] args) {
        //even number of coins will be given
        int[] arr = {20, 5, 4, 6};
        int n = arr.length;

        System.out.println("Maximum value can be collected : "+optimalStrategyRec(arr, 0, n-1));

        int[][] memo = new int[n][n];
        for(int[] row: memo)
            Arrays.fill(row, -1);
        System.out.println("Maximum value can be collected : "+optimalStrategyMemo(arr, 0, n-1, memo));
    }

    private static int optimalStrategyRec(int[] arr, int i, int j){
        //pointers surpass each other, no coins left
        if(i > j)
            return 0;

        //one coin left
        if(i == j)
            return arr[i];
        
        //when just two coins left
        if( i+1 == j)
            return Math.max(arr[i], arr[j]);
        
        //either we choose arr[i] or arr[j], opponent will choose in a way that we get min value in next moves
        //so we have to take maximum from both options
        return Math.max(arr[i] + Math.min(optimalStrategyRec(arr, i+2, j), optimalStrategyRec(arr, i+1, j-1)), 
        arr[j] + Math.min(optimalStrategyRec(arr, i+1, j-1), optimalStrategyRec(arr, i, j-2)));
    }


    private static int optimalStrategyMemo(int[] arr, int i, int j, int[][] memo){

        //Base cases
        if(i > j)
            return 0;

        if(i == j)
            return arr[i];
        
        if( i+1 == j)
            return Math.max(arr[i], arr[j]);
        
        //already computed then return
        if(memo[i][j] != -1)
            return memo[i][j];
        
        //take max possible outcome and store the result
        return memo[i][j] = Math.max(arr[i] + Math.min(optimalStrategyMemo(arr, i+2, j, memo), optimalStrategyMemo(arr, i+1, j-1, memo)), 
        arr[j] + Math.min(optimalStrategyMemo(arr, i+1, j-1, memo), optimalStrategyMemo(arr, i, j-2, memo)));
    }
}
