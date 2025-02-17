/**
 * Step-by-Step Explanation of Binary Search Code
 *
 * Definition:
 * - It takes a sorted array (arr) and a target value (target).
 * - Uses two pointers: left (starting index) and right (ending index).
 * - A loop runs while left <= right, meaning there are still elements to check.
 * - Calculates mid as (left + right) / 2.
 * - Three cases:
 *   - If arr[mid] == target, return mid (found).
 *   - If arr[mid] < target, search the right half (left = mid + 1).
 *   - If arr[mid] > target, search the left half (right = mid - 1).
 * - If no match is found, return -1.
 *
 * Inside the main method:
 * - Defines a sorted integer array {10, 20, 30, 40, 50}.
 * - Calls search() with the array and the target (30).
 * - If search() returns a valid index, it prints "Binary Search: Element found at index: X".
 * - Otherwise, it prints "Binary Search: Element not found."
 *
 * How it executes (for target = 30):
 * - Initial left = 0, right = 4, mid = (0+4)/2 = 2.
 * - arr[2] == 30 → Found at index 2 → Returns 2.
 *
 * Time Complexity:
 * - Worst case: O(log n) (Reduces the search space by half each time).
 * - Best case: O(1) (If mid is already the target).
 */

// Binary Search method


public class BinarySearch{
    public static int search(int[] arr, int target){
        int left = 0, right = arr.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2; // Avoids overflow

            if (arr[mid] == target)
                return mid; // Target found
            else if (arr[mid] < target)
                left = mid + 1; // Search right half
            else
                right = mid - 1; // Search left half
        }
        return -1; // Target not found
    }

    // Main method to test the search function
    public static void main(String[] args) {
        // Example array
        int[] numbers = {10, 20, 30, 40, 50}; // Must be sorted
        int target = 30;

        int result = search(numbers, target);
        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found.");
    }
}
