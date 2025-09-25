package algorithms.dp;

import java.util.Arrays;

/*
 * Max Cuts Problem
 *
 * Given a segment of length n and three possible cut lengths a, b, c,
 * the goal is to cut the segment into the maximum number of pieces
 * using only these lengths. If it is not possible to cut the segment
 * exactly, return -1.
 *
 * Approaches implemented:
 *   1. Recursive solution
 *      - Time Complexity: O(3^n)
 *      - Space Complexity: O(n) recursion stack
 *   2. Memoization (Top-down DP)
 *      - Time Complexity: O(n)
 *      - Space Complexity: O(n) for memo array + O(n) recursion stack
 *   3. Tabulation (Bottom-up DP)
 *      - Time Complexity: O(n)
 *      - Space Complexity: O(n) for DP array
 *
 * Example:
 *   n = 11, a = 2, b = 3, c = 5
 *   → Max cuts = 5 (cuts: 2+2+2+2+3)
 */

public class MaxCuts {
    public static void main(String[] args) {
        int n = 11; 
        int a = 2, b = 3, c = 5;
        
        System.out.println("Max cuts : "+maxCutsRec(n, a, b, c));

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println("Max cuts : "+maxCutsMemo(n, a, b, c, memo));

        System.out.println("Max cuts : "+maxCutsTabulation(n, a, b, c));
    }


    //Time Complexity: (3^n), Space Complexity: O(n) for recursion stack
    private static int maxCutsRec(int n, int a, int b, int c){
        if(n < 0)
            return -1;
        
        if(n == 0)
            return 0;
        
        //take the maximum from valid cuts
        //by using math.max, -1 for invalid cut will be neglected here
        int res = Math.max(maxCutsRec(n-a, a, b, c), Math.max(maxCutsRec(n-b, a, b, c), maxCutsRec(n-c, a, b, c)));


        if(res  == -1) //no valid cut found
            return -1;
        else //add 1 for curr segment
            return res + 1;
    }

    //Time Complexity:O(n), Space Complexity: O(n) for the memo array + O(n) recursion stack
    private static int maxCutsMemo(int n, int a, int b, int c, int[] memo){
        if(n < 0)
            return -1;
        
        if(n == 0)
            return 0;
        
        if(memo[n] != -1)
            return memo[n];
        
        //take the maximum value from valid cuts
        int res = Math.max(maxCutsMemo(n-a, a, b, c, memo), Math.max(maxCutsMemo(n-b, a, b, c, memo), maxCutsMemo(n-c, a, b, c, memo)));


        if(res  == -1) //if invalid from all cuts, return -1
            return -1;
        else// for valid one, add 1 for curr segment
            return memo[n] = res + 1;
    }

    //Time Complexity:O(n), Space Complexity: O(n) for the dp array
    private static int maxCutsTabulation(int n, int a, int b, int c){
        int[] dp = new int[n+1];
        
        Arrays.fill(dp, -1); //unreachable
        dp[0] = 0;

        for(int i=1; i<=n; i++){
            //check if current suggement i is greater than or equal to cuts
            //from all posible ways, take the maximum value
            if(i >= a && dp[i-a]!=-1)
                dp[i] = Math.max(dp[i], 1 + dp[i - a]);
            
            if(i >= b && dp[i-b]!=-1)
                dp[i] = Math.max(dp[i], 1 + dp[i - b]);
            
            if(i >= c && dp[i-c]!=-1)
                dp[i] = Math.max(dp[i], 1 + dp[i - c]);
        }

        return dp[n]; //result for segment of length n
     }
}
