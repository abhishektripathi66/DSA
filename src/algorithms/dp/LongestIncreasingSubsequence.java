package algorithms.dp;

import java.util.ArrayList;

/*
 * Longest Increasing Subsequence (LIS)
 *
 * Given an array of integers, find the length of the longest subsequence such that all elements 
 * of the subsequence are sorted in strictly increasing order.
 *
 * Approaches:
 *   1. Dynamic Programming (O(n²)): Compare each element with all previous ones to build 
 *      the length of increasing subsequences.
 *   2. Binary Search Optimization (O(n log n)): Maintain a tail array of potential 
 *      subsequence ends and use binary search to update positions efficiently.
 *
 * Time Complexity:
 *   - Tabulation (DP): O(n²)
 *   - Binary Search: O(n log n)
 * Space Complexity:
 *   - O(n) for DP and tail array
 *
 * Example:
 *   arr = [8, 100, 150, 10, 12, 14, 110]
 *   → LIS length = 5  (8, 10, 12, 14, 110)
 */

public class LongestIncreasingSubsequence {

    public static void main(String[] args){
        int[] arr = {8, 100, 150, 10, 12, 14, 110};
        int n = arr.length;

        //LIS: 8, 10, 12, 14, 110
        System.out.println("LIS : "+LISTabulation(arr, n));
        System.out.println("LIS : "+LISBinarySearch(arr, n));
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

    //Time Complexity : O(n*logn), Space Complexity: O(n)
    private static int LISBinarySearch(int[] arr, int n){

        //tail to store minimum possible elements to form LIS
        ArrayList<Integer> tail = new ArrayList<>();
        tail.add(arr[0]);

        for(int i=1; i<n; i++){
            //if arr[i] is greather than last inserted element then add it directly
            if(arr[i] > tail.get(tail.size() - 1)){
                tail.add(arr[i]);
            }
            else{ //otherwise look for valid index such that increasing order is maintained
                int c = ceilIdx(tail, 0, tail.size() - 1, arr[i]);
                tail.set(c, arr[i]);
            }
        }

        return tail.size();
    }

    //it will return ceil index foor given element x such that list's increasing order is maintained
    private static int ceilIdx(ArrayList<Integer> tail, int l, int r, int x){

        while(l  < r){ //can not use <=, because updating r with r = m
            int m = (l + r)/2;

            if(tail.get(m) == x) //when same value is already present, return index of it
                return m;
            else if(tail.get(m) > x) //got ceil index to replace, check further efficient one
                r = m;
            else//got smaller value, check for greater one
                l = m+1;
            
            /* //Same as above
            if (tail.get(m) >= x)
                r = m;
            else
                l = m + 1; 
            */
        }

        return r; //return final ceil index
    }
}
