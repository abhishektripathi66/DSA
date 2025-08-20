package algorithms.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args){
        String s1 = "AXYZ";
        String s2 = "BAZ";
        int m = s1.length();
        int n = s2.length();

        int[][] memo = new int[m+1][n+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        
        System.out.println("LCS : "+LongestCommonSubsequenceMemo(s1, s2, m, n, memo));//2 for 'AZ'

    }

    private static int LongestCommonSubsequenceMemo(String s1, String s2, int m, int n, int[][] memo){

        if(memo[m][n] != -1)
            return memo[m][n];
        
        if(m==0 || n==0)
            return 0;
        
        if(s1.charAt(m-1) == s2.charAt(n-1))
            return memo[m][n] = 1 + LongestCommonSubsequenceMemo(s1, s2, m-1, n-1, memo);
        else
            return memo[m][n] = Math.max(LongestCommonSubsequenceMemo(s1, s2, m-1, n, memo), LongestCommonSubsequenceMemo(s1, s2, m, n-1, memo));
        
    }
}
