package algorithms.dp;

import java.util.Arrays;

public class AllocateMinimumPages {
    public static void main(String[] args){
        int[] arr = {10, 20, 30, 40};
        int k = 2;
        int n = arr.length;
        System.out.println("Minimized maximum pages : "+allocateMinimumPagesRec(arr, n, k));

        int[][] memo = new int[n+1][k+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        System.out.println("Minimized maximum pages : "+allocateMinimumPagesMemo(arr, n, k, memo));

        System.out.println("Minimized maximum pages : "+allocateMinimumPagesTabulation(arr, n, k));

        System.out.println("Minimized maximum pages using binary search : "+allocateMinimumPagesBinarySearch(arr, n, k));
    }
    
    //Time complexity: Exponential (≈ O(k × 2^n))
    private static int allocateMinimumPagesRec(int[] arr, int n, int k){

        //all books go to one student
        if(k == 1)
            return sum(arr, 0, n-1);
        
        //only one book left 
        if(n == 1)
            return arr[0];
        
        int res = Integer.MAX_VALUE;

        for(int i=1; i<n; i++){
            //first i books go to k-1 students, and the rest go to the last one
            res = Math.min(res, Math.max(allocateMinimumPagesRec(arr, i, k-1), sum(arr, i, n-1)));
        }

        //return the minimized res
        return res;
    }


    //Time Complexity: O(n^2 * k), Total states =  n × k, Work per state =  O(n)
    private static int allocateMinimumPagesMemo(int[] arr, int n, int k, int[][] memo){
        //Base cases
        //one student, all books go to them
        if(k == 1)
            return sum(arr, 0, n-1);
        
        //only one book left 
        if(n == 1)
            return arr[0];
        
        //already computed
        if(memo[n][k] != -1)
            return memo[n][k];
        
        int res = Integer.MAX_VALUE;
        //for every state (n, k), we use loop to look for optimal split
        for(int i=1; i<n; i++){
            //first i books for k-1 students, and reaming for last student
            res = Math.min(res, Math.max(allocateMinimumPagesMemo(arr, i, k-1, memo), sum(arr, i, n-1)));
        }

        //store and return the result
        return memo[n][k] = res;
    }

    //Time complexity: O(k * n^3) -> Could be O(k * n^2) if we use prefix sum instead calling sum everytime
    private static int allocateMinimumPagesTabulation(int[] arr, int n, int k){
        
        int[][] dp = new int[k+1][n+1]; //reverse ordering compared to memoization table

        for(int i=1; i<=k; i++)
            dp[i][1] = arr[0];

        for(int j=1; j<=n; j++)
            dp[1][j] = sum(arr, 0, j-1);
        
        for(int i=2; i<=k; i++){
            for(int j=2; j<=n; j++){
                int res = Integer.MAX_VALUE;

                //try partitioning from 1 to j-1
                for(int p = 1; p<j; p++){
                    res = Math.min(res, Math.max(dp[i-1][p], sum(arr, p, j-1)));
                }

                dp[i][j] = res;
            }
        }

        return dp[k][n];
    }

    //Time Complexity: O(nlog(sum))
    //allocation should be continous, okay if given array is not sorted
    private static int allocateMinimumPagesBinarySearch(int[] arr, int n, int k){
        int sum = 0, max = 0;
        for(int page : arr){
            max = Math.max(max, page);
            sum += page;
        }

        int low = max, high = sum, res = -1;

        while(low <= high){
            int mid = (low + high)/2;

            if(isFeasible(arr, n, k, mid)){
                res = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;

        }
        return res;
    }

    //doesn’t explore all possibilities like recursion or dp, instead it makes a greedy choice
    private static boolean isFeasible(int[] arr, int n, int k, int ans){

        int req = 1, sum = 0;

        for(int i=0; i<n; i++){
             if(arr[i] > ans) // single book exceeds limit
                return false;

            if(sum + arr[i] > ans){ //when about to exceed
                sum = arr[i];
                req++;
            }
            else
                sum += arr[i];
        }

        return req <= k;
    }

    //utility method to count number of pages in given range
    private static int sum(int[] arr, int b, int e){
        int sum = 0;
        for(int i=b; i<=e; i++)
            sum += arr[i];
        return sum;
    }
}
