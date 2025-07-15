package algorithms.sortingalgorithms.mergesort;

/**
 * Merge Sort Algorithm
 * ----------------------
 * A stable, divide-and-conquer sorting algorithm that recursively divides the array
 * into halves, sorts them, and merges them back.
 * <p>
 * Time Complexity: O(n log n) in all cases.
 * Space Complexity: O(n) due to temporary arrays used for merging.
 * <p>
 * Author: Shubhanjay Tiwari
 */
public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array.length < 2) return;

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(left, right, array);
    }

    private static void merge(int[] left, int[] right, int[] array) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 9, 1, 2, 6, 4};
        System.out.println("Before Merge Sort:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("After Merge Sort:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}