package algorithms.dp;

import java.util.Arrays;

//Same as Coin Change Combination
public class SubsetSumCombination {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 3, 6};
        int sum = 8;
        int n = arr.length;

        System.out.println("Number of subsets with given sum : "+countSubset(arr, n, sum));
        
        int[][] memo = new int[n+1][sum+1];
        for(int[] row : memo)
                Arrays.fill(row, -1);
        System.out.println("Number of subsets with given sum : "+countSubsetMemo(arr, n, sum, memo));

        System.out.println("Number of subsets with given sum : "+countSubsetTabulation(arr, n, sum));

    }

    //Time Complexity: O(2^n) with include and exclude approach, Space Complexity: O(n) for recursion stack
    private static int countSubset(int[] arr, int n, int sum){

        //if sum become less than 0
        if( sum < 0)
            return 0;

        //at the end and found valid combination then return 0
        if(n == 0)
            return (sum == 0) ? 1 : 0;
        
        //exclude the current element + include the current element
        return countSubset(arr, n-1, sum) + countSubset(arr, n-1, sum - arr[n-1]);
    }

    //Time Complexity: O(n*sum), Space Complexity: O(n*sum) + O(n) recursion stack
    private static int countSubsetMemo(int[] arr, int n, int sum, int[][] memo){

        //invalid sum value
        if(sum < 0)
            return 0;
        
        //at the end, return 1 based on if sum is achieved or not
        if(n == 0)
            return (sum == 0) ? 1 : 0;
    
        //return computed result
        if(memo[n][sum]!=-1)
            return memo[n][sum];

        //exlude and include approach
        return memo[n][sum] = countSubsetMemo(arr, n-1, sum, memo) + countSubsetMemo(arr, n-1, sum - arr[n-1], memo);
    }

    private static int countSubsetTabulation(int[] arr, int n, int sum){
        int[][] dp = new int[n+1][sum+1];

        //when sum is achieved
        for(int i=0; i<=n; i++)
            dp[i][0] = 1;
        
        //when no values left and sum > 0
        for(int j=1; j<=sum; j++)
            dp[0][j] = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                dp[i][j] += dp[i-1][j]; //exluding current value

                if(arr[i-1] <= j) //include curr value if less than curr sum value
                    dp[i][j] += dp[i][j - arr[i-1]];
            }
        }

        return dp[n][sum];
    }

}
