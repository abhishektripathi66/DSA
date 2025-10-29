package algorithms.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {

    //the algorithm finds the optimal order of multiplication (parenthesization) 
    //that results in the minimum number of multiplications required to compute the final product

    /*
     * Matrix Chain Multiplication Problem
     * 
     * Given a sequence of matrices, the goal is to determine the most efficient order 
     * (parenthesization) to multiply them so that the total number of scalar multiplications
     * required is minimized.
     * 
     * The problem does not perform actual matrix multiplication — it only finds the optimal
     * order to minimize computational cost.
     * 
     * Example: arr = [2, 1, 3, 4] → Matrices: A1(2×1), A2(1×3), A3(3×4)
     * 
     * Possible parenthesizations
     *
     * 1. (A₁ × A₂) × A₃
     * Cost of A₁ × A₂ = 2×1×3 = 6
     * Resulting matrix = 2×3
     * Then multiply (2×3) × (3×4) = 2×3×4 = 24
     * Total = 6 + 24 = 30
     
     * 2. A₁ × (A₂ × A₃)
     * Cost of A₂ × A₃ = 1×3×4 = 12
     * Resulting matrix = 1×4
     * Then multiply (2×1) × (1×4) = 2×1×4 = 8
     * Total = 12 + 8 = 20 
     * 
     * → So, Minimum cost = 20
    */
    

    public static void main(String[] args){
        int[] arr = {2, 1, 3, 4};
        int n = arr.length;

        System.out.println("Minimum number of multiplications : "+matrixChainMultiplicationRec(0, n-1, arr));

        int[][] memo = new int[n][n];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        System.out.println("Minimum number of multiplications : "+matrixChainMultiplicationMemo(0, n-1, arr, memo));
        System.out.println("Minimum number of multiplications : "+matrixChainMultiplicationTabulation(arr, n));
    }

    //Time complextity: O(2^n) and Auxilliary Space Complexity : O(n)
    private static int matrixChainMultiplicationRec(int i, int j, int[] arr){

        //partition must have atleast two elements

        //Base case: just one matrix (no multiplication needed)
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

    
    /*
     * Time Complexity: O(n^3)
     *   - i can go from 0 to n-2 and j can go from i+1 to n-1
     *   - that’s O(n^2) subproblems on which we perform O(n) loop so total time complexity O(n^3)
     * 
     * Space Complexity: O(n^2) for memo table +  O(n) for recursion stack space
     */
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

    /*
     * Time Complexity:  O(n^3)
     *   - There are O(n^2) entries in the dp table.
     *   - For each (i, j) pair, we check O(n) possible splits 'k'.
     *   - Total = O(n^3)
     *
     * Space Complexity: O(n^2)
     *   - dp table of size n x n.
     *   - No recursion stack used (iterative solution).
     */
    private static int matrixChainMultiplicationTabulation(int[] arr, int n) {

        // dp[i][j] = Minimum number of multiplications needed
        // to compute matrices from index i to j
        int[][] dp = new int[n][n];

        // Base case: For chain length 1 (i + 1 == j), cost = 0
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = 0;
        }

        // l = current chain length (at least 2 matrices)
        for (int len = 2; len < n; len++) {
            // i = start index of the chain
            for (int i = 0; i + len < n; i++) {
                int j = i + len; // end index of the chain
                dp[i][j] = Integer.MAX_VALUE;

                // Try all possible partition points
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        //minimum cost to multiply entire chain (0...n-1)
        return dp[0][n - 1];
    }

}
