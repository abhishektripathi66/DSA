package algorithms.dp;

public class LongestIncreasingSubsequence {

    public static void main(String[] args){
        int[] arr = {3, 4, 2, 8, 10};
        int n = arr.length;

        System.out.println("LIS : "+LISTabulation(arr, n));
    }

    //Bottom-up approach
    //Time Complexity : O(n^2), Space Complexity: O(n)
    private static int LISTabulation(int[] arr, int n){
        int[] lis = new int[n];

        lis[0] = 1;

        for(int i=1; i<n; i++){
            lis[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }

        int res = lis[0];
        for(int i=1; i<n; i++)
            res = Math.max(res, lis[i]);

        return res;
    }
}
