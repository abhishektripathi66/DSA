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
    }
    
    //Time complexity: O(2^n)
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

    //utility method to count number of pages in given range
    private static int sum(int[] arr, int b, int e){
        int sum = 0;
        for(int i=b; i<=e; i++)
            sum += arr[i];
        return sum;
    }
}
