
package codingquestions.problemsonsorting.quicksort;

import algorithms.sortingalgorithms.quicksort.QuickSort;

public class MinimumDifference {

    public static void main(String[] args) {
        int[] arr = {1,8,12,5,18,3};
        System.out.println("Minimum difference: " + findMinimumDifference(arr));
    }

    public static int findMinimumDifference(int[] arr){
        QuickSort.quickSortUsingHoare(arr,0,arr.length-1);
        int minDiff=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            minDiff = Math.min(minDiff, arr[i] -arr[i-1]);
        }
        return minDiff;
    }
}