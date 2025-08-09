package algorithms.sortingalgorithms.quicksort;

/**
 * Quick Sort Algorithm
 * ---------------------
 * An efficient, divide-and-conquer sorting algorithm that uses a pivot to partition the array
 * into subarrays which are then sorted recursively.
 * <p>
 * Time Complexity: O(n log n) average, O(n^2) worst case.
 * Space Complexity: O(log n) due to recursive stack.
 * <p>
 * Author: Shubhanjay Tiwari
 */
public class QuickSort {

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }

    public static void quickSortUsingLomuto(int[] arr, int start, int end){
        if(start<end){
            int p = ParitionFunction.LumutoPartition(arr, start, end);
            quickSortUsingLomuto(arr, start, p-1);
            quickSortUsingLomuto(arr, p+1, end);
        }
    }

    public static void quickSortUsingHoare(int[] arr,int start, int end){
        if(start<end){
            int p = ParitionFunction.HoarePartition(arr, start, end);
            quickSortUsingHoare(arr, start, p);
            quickSortUsingHoare(arr, p+1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 9, 1, 2, 6, 4};
        System.out.println("Before Quick Sort:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("After Quick Sort:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
