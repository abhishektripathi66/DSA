package algorithms.dp;

import java.util.Arrays;

/*
 * Palindrome Partitioning – Minimum Cuts
 *
 * Given a string s, partition it so that every substring in the partition is a palindrome.
 * Return the minimum number of cuts required to achieve such a partition.
 *
 * Example:
 *   s = "aab"
 *   Possible partitions: ["aa" | "b"], ["a" | "a" | "b"]
 *   → Minimum cuts = 1
 */


public class PalindromePartitioning {

    //minimum number of cuts required to make all strings palindrome
    public static void main(String[] args) {
        String s = "abbac";
        int n = s.length();
        System.out.println("Mimum cuts required : "+isPalindromeRec(s, 0, n-1));

        int[][] memo = new int[n+1][n+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        System.out.println("Mimum cuts required : "+isPalindromeMemo(s, 0, n-1, memo));

        System.out.println("Mimum cuts required : "+isPalindromeTabulation(s, n));


    }
    
    //Time complexity: O(2^n), Space complexity: O(n)
    private static int isPalindromeRec(String s, int i, int j){

        //Base case
        if(i>=j || isPalindrome(s, i, j))
            return 0;
        
        int res = Integer.MAX_VALUE;

        for(int k=i; k<j; k++){
            //one cut made, check on the other two parts from cut
            res = Math.min(res, 1 + isPalindromeRec(s, i, k) + isPalindromeRec(s, k+1, j));
        }

        return res;
    }

    //Time complexity: O(n^3) -> Total states = O(n^2), Work per state = O(n)
    //Space complexity: O(n^2)
    private static int isPalindromeMemo(String s, int i, int j, int[][] memo){
        //Base case
        if(i>=j || isPalindrome(s, i, j))
            return 0;
        
        //return result if already computed
        if(memo[i][j] != -1)
            return memo[i][j];
        
        int res = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            //take the minimum value from all cuts
            res = Math.min(res, 1 + isPalindromeMemo(s, i, k, memo) + isPalindromeMemo(s, k+1, j, memo));
        }

        //store and return result
        return memo[i][j] = res;
    }

    //Time complexity: O(n^3), Space complexity: O(n^2)
    //Time complexity can be O(n^2) if we precompute isPalindrome array
    private static int isPalindromeTabulation(String s, int n){
        int[][] dp = new int[n][n];
        boolean[][] isPalindrome = new boolean[n][n]; //so we don't have to call isPalindrome function for overlalping substrings

        for(int i=0; i<n; i++){
            isPalindrome[i][i] = true;
            dp[i][i] = 0;
        }

        for(int gap=1; gap<n; gap++){
            for(int i=0, j = i+gap; j<n; i++, j++){ //i,j will be of substring of aleast length 2

                //if both characters are same and substring(i+1, j-1) is already palidrome
                if (s.charAt(i) == s.charAt(j) && (j - i == 1 || isPalindrome[i+1][j-1])) {
                    isPalindrome[i][j] = true;
                    dp[i][j] = 0;
                }
                else{
                    int res = Integer.MAX_VALUE;
                    //try putting cuts for substring s[i..j]
                    for(int k=i; k<j; k++){
                        res = Math.min(res, 1 + dp[i][k] + dp[k+1][j]);
                    }
                    dp[i][j] = res;
                }
            }
        }

        return dp[0][n-1];
    }

    private static boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }
}
