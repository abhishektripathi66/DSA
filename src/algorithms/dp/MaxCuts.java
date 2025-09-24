package algorithms.dp;

import java.util.Arrays;

public class MaxCuts {
    public static void main(String[] args) {
        int n = 11; 
        int a = 2, b = 3, c = 5;
        
        System.out.println("Max cuts : "+maxCutsRec(n, a, b, c));
        System.out.println("Max cuts : "+maxCutsTabulation(n, a, b, c));
    }


    //Time Complexity: (3^n)
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
