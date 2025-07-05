/**
 * Bubble Sort Algorithm
 * ----------------------
 * Repeatedly steps through the list, compares adjacent elements,
 * and swaps them if they are in the wrong order.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 * Author: Shubhanjay Tiwari
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
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