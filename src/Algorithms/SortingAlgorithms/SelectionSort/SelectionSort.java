/**
 * Selection Sort Algorithm
 * -------------------------
 * Repeatedly finds the minimum element from the unsorted part
 * and moves it to the beginning.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 * Author: Shubhanjay Tiwari
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 8, 9, 1, 2, 6, 4 };
        System.out.println("Before Selection Sort:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("After Selection Sort:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}