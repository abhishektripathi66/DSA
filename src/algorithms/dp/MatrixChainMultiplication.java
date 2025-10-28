package algorithms.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {

    //the algorithm finds the optimal order of multiplication (parenthesization) 
    //that results in the minimum number of multiplications required to compute the final product

    public static void main(String[] args){
        int[] arr = {2, 1, 3, 4};
        int n = arr.length;

        System.out.println("Minimum number of multiplications : "+matrixChainMultiplicationRec(0, n-1, arr));

        int[][] memo = new int[n][n];
        for(int[] row : memo)
            Arrays.fill(row, -1);
    }

    //Time complextity: O(2^n) and Auxilliary Space Complexity : O(n)
    private static int matrixChainMultiplicationRec(int i, int j, int[] arr){

        //partition must have atleast two elements

        //Base case: just one dimimension
        if( i + 1 == j)
            return 0;
    
        int res = Integer.MAX_VALUE;

        //for current window if there are n elements then there are n-1 ways to put brackets
        //try including different elements in current bracket
        for(int k=i+1; k<j; k++){
            
            //For every k, we make two subproblems : (a) Chain from i to k  (b) Chain from k to j
            int curr = (matrixChainMultiplicationRec(i, k, arr) + matrixChainMultiplicationRec(k, j, arr)) + arr[i]*arr[k]*arr[j];

            res = Math.min(res, curr);
        }
        
        //return minimum count
        return res;
    }


    //Time Complexity: O(n^3)
    //i can go from 0 to n-2 and j can go from i+1 to n-1
    //that’s O(n^2) subproblems on which we perform O(n) loop so total time complexity O(n^3)
    //Auxilliary Space Complexity : O(n^2) for memo table +  O(n) for recursion stack space
    private static int matrixChainMultiplicationMemo(int i, int j, int[] arr, int[][] memo) {
        // Base case: Only one matrix
        if (i + 1 == j)
            return 0;

        //return cached value if already computed
        if (memo[i][j] != -1)
            return memo[i][j];

        int res = Integer.MAX_VALUE;

        //try placing parentheses at all valid positions
        for (int k = i + 1; k < j; k++) {
            
            //there are O(n^2) unique subproblems (for all pairs (i, j)) so overall time complexity will be O(n^3)
            int left = matrixChainMultiplicationMemo(i, k, arr, memo);
            int right = matrixChainMultiplicationMemo(k, j, arr, memo);
            int cost = arr[i] * arr[k] * arr[j];
            int curr = left + right + cost;

            res = Math.min(res, curr);
        }

        //store result and return
        return memo[i][j] = res;
    }
}
