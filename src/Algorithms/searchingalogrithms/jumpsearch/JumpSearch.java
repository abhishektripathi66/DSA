package algorithms.searchingalogrithms.jumpsearch;

import java.util.*;

/**
 * Jump Search Algorithm to efficiently find an element in a sorted array.
 */
public class JumpSearch {
    // List of test cases to check different values
    public static List<Integer> testCases = Arrays.asList(23, 72, 5, 91, 100);

    public static void main(String[] args) {
        // Sorted array for searching
        int[] sortedArray = {2, 3, 5, 8, 12, 16, 23, 38, 56, 72, 91};

        // Run jump search for each test case
        for (int target : testCases) {
            int index = jumpSearch(sortedArray, target);
            if (index != -1) {
                System.out.println("Element " + target + " found at index: " + index);
            } else {
                System.out.println("Element " + target + " not found in the array.");
            }
        }
    }

    /**
     * Performs Jump Search on a sorted array.
     *
     * @param arr    The sorted array to search in
     * @param target The element to find
     * @return The index of the element if found, otherwise -1
     */
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n)); // Step size
        int prev = 0;

        // Jump in steps of 'step' until we find a block where target could be
        while (prev < n && arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1; // Element is not present
            }
        }

        // Linear search in the identified block
        while (prev < Math.min(step, n)) {
            if (arr[prev] == target) {
                return prev; // Return index if found
            }
            prev++;
        }

        return -1; // Element not found
    }
}
