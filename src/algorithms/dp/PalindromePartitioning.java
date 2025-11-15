package algorithms.dp;

import java.util.Arrays;

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

    }
    
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
