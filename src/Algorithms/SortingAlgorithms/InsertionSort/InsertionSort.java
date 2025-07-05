/**
 * Insertion Sort Algorithm
 * -------------------------
 * Builds the final sorted array one item at a time by inserting elements
 * into their correct position.
 *
 * Time Complexity: O(n^2) worst, O(n) best
 * Space Complexity: O(1)
 *
 * Author: Shubhanjay Tiwari
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 8, 9, 1, 2, 6, 4 };
        System.out.println("Before Insertion Sort:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("After Insertion Sort:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
