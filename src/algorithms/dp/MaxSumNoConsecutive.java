package algorithms.dp;

import java.util.Arrays;

/*
 * Maximum Sum of Non-Consecutive Elements
 *
 * Given an array of integers, find the maximum sum of elements such that
 * no two chosen elements are adjacent in the array.
 *
 * This is a classic Dynamic Programming problem, often seen as a variation
 * of the "House Robber Problem".
 *
 * Approaches:
 *   1. Pure Recursion → Exponential time (O(2^n)), O(n) stack space
 *   2. Recursion with Memoization → O(n) time, O(n) space
 *   3. Tabulation (Bottom-Up DP) → O(n) time, O(n) space
 *   4. Space-Optimized DP → O(n) time, O(1) space
 *
 * Example:
 *   arr = [8, 7, 6, 10]
 *   → Max sum = 18 (from 8 + 10)
 */

public class MaxSumNoConsecutive {
    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 10};
        int n = arr.length;

        System.out.println("Max sum without taking two consecutive elements : "+maxSumRec(arr, n)); //18 (from 8 and 10)

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println("Max sum without taking two consecutive elements : "+maxSumMemo(arr, n, memo));

        System.out.println("Max sum without taking two consecutive elements : "+maxSumTabulation(arr, n));
    }

    //Time Complexiy : O(2^n), Space Complexity: O(n) for recurvise call stack
    private static int maxSumRec(int[] arr, int n){
        if(n <= 0)
            return 0;
        
        if(n == 1)
            return arr[0];
        
        if(n == 2)
            return Math.max(arr[0], arr[1]);
        
        //either skip curr element or take curr element and skip one before it
        return Math.max(maxSumRec(arr, n-1), arr[n-1] + maxSumRec(arr, n-2));
    }

    //Same procedure as recursive approach
    //Time Complexiy : O(n), Space Complexity: O(n) for memo and recurvise call stack
    private static int maxSumMemo(int[] arr, int n, int[] memo){
        if(n <= 0)
            return 0;
        
        //returning result if computed previously
        if(memo[n]!=-1)
            return memo[n];
        
        if(n == 1)
            return memo[n] = arr[0];
        
        if(n == 2)
            return memo[n] = Math.max(arr[0], arr[1]);
        
        return memo[n] = Math.max(maxSumMemo(arr, n-1, memo), arr[n-1] + maxSumMemo(arr, n-2, memo));
    }

    //Time Complexiy : O(n), Space Complexity: O(n)
    private static int maxSumTabulation(int[] arr, int n){

        if(n == 0) 
            return 0;
        if(n == 1) 
            return arr[0];
        
        if(n == 2)
            return Math.max(arr[0], arr[1]);

            
        //It will have Space complexity O(n)
        /*int[] dp = new int[n];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i=2; i<n; i++){
            dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]);
        }
        return dp[n-1];*/

        //Optimized approach with Space Complexity O(1)

        int prev1 = arr[0];
        int prev2 = Math.max(arr[0], arr[1]);

        for(int i=2; i<n; i++){
            int curr = Math.max(arr[i] + prev1, prev2);

            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }
}
