package codingquestions.problemsonsorting.quicksort;

import algorithms.sortingalgorithms.quicksort.QuickSort;

public class ChoclateDistribution {
    
    public static void main(String[] args) {
        int[] arr = {7,3,2,4,9,12,56};
        System.out.println(findChoclateDistribution(arr, 3));
    }

    public static int findChoclateDistribution(int[] arr, int m){
        if(arr.length <m) return -1;
        QuickSort.quickSortUsingHoare(arr, 0, arr.length-1);
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-m+1;i++){
            minDiff = Math.min(minDiff,arr[i+m-1]-arr[i]);
        }
        return minDiff;
    }

}
