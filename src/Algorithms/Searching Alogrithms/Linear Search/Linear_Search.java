/**
 * Step-by-Step Explanation of Linear Search Code
 *
 * Definition:
 * - It takes an array (arr) and a target value (target).
 * - Loops through the array from index 0 to n-1.
 * - If the current element matches target, it returns the index.
 * - If no match is found after checking all elements, it returns -1 (meaning "not found").
 *
 * Inside the main method:
 * - Defines an integer array {10, 20, 30, 40, 50}.
 * - Calls search() with the array and the target (30).
 * - If search() returns a valid index, it prints "Element found at index: X".
 * - Otherwise, it prints "Element not found."
 *
 * How it executes:
 * - It checks 10 → Not 30.
 * - It checks 20 → Not 30.
 * - It checks 30 → Match found at index 2 → Returns 2.
 *
 * Time Complexity:
 * - Worst case: O(n) (If the target is at the end or not in the list).
 * - Best case: O(1) (If the target is at position 0).

 */

// Linear Search method
public class Linear_Search{
    public static int search(int[] arr, int target){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == target)
                return i; // Return index if target is found
        }
        return -1; // Return -1 if target is not found
    }

    public static void main(String[] args){
        // Example array
        int[] numbers = {10, 20, 30, 40, 50};
        int target = 30;

        int result = search(numbers, target);
        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found.");
    }
}