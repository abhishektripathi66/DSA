package algorithms.sortingalgorithms.bubblesort;

/**
 * Bubble Sort Algorithm
 *
 * This class provides an implementation of the Bubble Sort algorithm,
 * which repeatedly compares adjacent elements and swaps them if they
 * are in the wrong order.
 *
 * Time Complexity:
 * - Best Case: O(n)
 * - Average Case: O(n^2)
 * - Worst Case: O(n^2)
 *
 * Space Complexity:
 * - O(1) (In-place sorting)
 * * Author: Tejas Guntiwar
 */
public class BubbleSort {

    /**
     * Sorts the given array using Bubble Sort.
     *
     * @param arr the array to be sorted
     */
    static void bubbleSort(int[] arr) {
        int length = arr.length;

        // Traverse through all array elements
        for (int pass = 0; pass < length; pass++) {

            // Last pass elements are already in correct position
            for (int index = 0; index < length - pass - 1; index++) {

                // Swap adjacent elements if they are in wrong order
                if (arr[index] > arr[index + 1]) {
                    int temp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 8, 9, 1, 2, 6, 4 };
        System.out.println("Before Bubble Sort:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("After Bubble Sort:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}