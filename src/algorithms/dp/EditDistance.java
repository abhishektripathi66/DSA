package algorithms.dp;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args){
        String s1 = "SATURDAY";
        String s2 = "SUNDAY";

        int m = s1.length();
        int n = s2.length();

        int[][] memo = new int[m+1][n+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        
        System.out.println("Minimum edits required to convert S1 to S2 : " +editDistanceMemo(s1, s2, m, n, memo));
    }

    private static int editDistanceMemo(String s1, String s2, int m, int n, int[][] memo){

        if(memo[m][n] != -1)
            return memo[m][n];

        if(m == 0)
            return memo[m][n] = n;
        
        if(n == 0)
            return memo[m][n] = m;
        
        
        if(s1.charAt(m-1) == s2.charAt(n-1)) //if same character, we don't have to perform any operation
            return memo[m][n] = editDistanceMemo(s1, s2, m-1, n-1, memo);
        else//otherwise take the min from insert, delete, replace add +1 for action taken
            return memo[m][n] = 1 + Math.min(editDistanceMemo(s1, s2, m, n-1, memo), Math.min(editDistanceMemo(s1, s2, m-1, n, memo), editDistanceMemo(s1, s2, m-1, n-1, memo)));
    }
}
