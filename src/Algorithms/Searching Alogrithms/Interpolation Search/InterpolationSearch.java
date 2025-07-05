/**
 * Interpolation Search Algorithm
 * --------------------------------
 * Interpolation Search is an efficient search algorithm for sorted and uniformly distributed arrays.
 * It estimates the position of the target using its value, often outperforming Binary Search for
 * uniformly distributed data.
 *
 * Best Case: O(1)
 * Average Case: O(log log n)
 * Worst Case: O(n)
 *
 * Prerequisites:
 * - Array must be sorted in ascending order.
 * - Uniform distribution of data is required for optimal performance.
 *
 * Author: Shubhanjay Tiwari
 */
public class InterpolationSearch {

    /**
     * Performs Interpolation Search on a sorted, uniformly distributed array.
     *
     * @param arr    The sorted array to search in
     * @param target The element to find
     * @return The index of the element if found, otherwise -1
     */
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            // If all elements are the same, avoid division by zero
            if (arr[high] == arr[low]) {
                if (arr[low] == target) {
                    return low;
                } else {
                    return -1;
                }
            }

            // Estimate the probable position using interpolation formula
            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            // Check if the element at pos is the target
            if (arr[pos] == target) {
                return pos;
            }

            // If target is larger, it is in the upper part
            if (arr[pos] < target) {
                low = pos + 1;
            }
            // If target is smaller, it is in the lower part
            else {
                high = pos - 1;
            }
        }

        // Target not found
        return -1;
    }

    /**
     * Main method to demonstrate Interpolation Search with example test cases.
     */
    public static void main(String[] args) {
        int[] sortedArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] testCases = {40, 90, 15, 100, 5};

        for (int target : testCases) {
            int result = interpolationSearch(sortedArray, target);
            if (result != -1) {
                System.out.println("Element " + target + " found at index: " + result);
            } else {
                System.out.println("Element " + target + " not found in the array.");
            }
        }
    }
}
