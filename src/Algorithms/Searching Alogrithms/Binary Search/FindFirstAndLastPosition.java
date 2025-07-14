/**
 * Find First and Last Position of Element in Sorted Array
 * ======================================================
 * 
 * Problem Statement:
 * Given an array of integers nums sorted in non-decreasing order, find the starting 
 * and ending position of a given target value. If target is not found in the array, 
 * return [-1, -1].
 * 
 * Example:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Key Concepts:
 * 1. Binary Search for Leftmost Position (First Occurrence)
 * 2. Binary Search for Rightmost Position (Last Occurrence)
 * 3. Handling edge cases when target is not found
 * 
 * Time Complexity: O(log n) - Two binary searches
 * Space Complexity: O(1) - Constant extra space
 * 
 * Author: Abhishek Tripathi
 * Date: 2024
 */
public class FindFirstAndLastPosition {
    
    /**
     * Main method to demonstrate the solution
     */
    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        
        int[] nums3 = {1, 1, 1, 1, 1};
        int target3 = 1;
        
        System.out.println("=== Find First and Last Position Demo ===");
        
        // Test Case 1: Target exists multiple times
        int[] result1 = searchRange(nums1, target1);
        System.out.println("Array: [5, 7, 7, 8, 8, 10], Target: " + target1);
        System.out.println("Result: [" + result1[0] + ", " + result1[1] + "]");
        System.out.println("Expected: [3, 4]");
        System.out.println();
        
        // Test Case 2: Target doesn't exist
        int[] result2 = searchRange(nums2, target2);
        System.out.println("Array: [5, 7, 7, 8, 8, 10], Target: " + target2);
        System.out.println("Result: [" + result2[0] + ", " + result2[1] + "]");
        System.out.println("Expected: [-1, -1]");
        System.out.println();
        
        // Test Case 3: All elements are target
        int[] result3 = searchRange(nums3, target3);
        System.out.println("Array: [1, 1, 1, 1, 1], Target: " + target3);
        System.out.println("Result: [" + result3[0] + ", " + result3[1] + "]");
        System.out.println("Expected: [0, 4]");
        System.out.println();
        
        // Interactive demo
        System.out.println("=== Interactive Demo ===");
        int[] demoArray = {1, 2, 2, 2, 3, 4, 4, 5, 6, 6, 6, 7};
        System.out.println("Demo Array: [1, 2, 2, 2, 3, 4, 4, 5, 6, 6, 6, 7]");
        
        for (int target = 1; target <= 7; target++) {
            int[] result = searchRange(demoArray, target);
            System.out.println("Target " + target + " → [" + result[0] + ", " + result[1] + "]");
        }
    }
    
    /**
     * Finds the first and last position of target in the sorted array
     * 
     * @param nums Sorted array of integers
     * @param target Value to search for
     * @return Array containing [firstPosition, lastPosition] or [-1, -1] if not found
     */
    public static int[] searchRange(int[] nums, int target) {
        // Handle edge case: empty array
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        // Find the leftmost (first) occurrence of target
        int firstPosition = findFirstPosition(nums, target);
        
        // If target is not found, return [-1, -1]
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        
        // Find the rightmost (last) occurrence of target
        int lastPosition = findLastPosition(nums, target);
        
        return new int[]{firstPosition, lastPosition};
    }
    
    /**
     * Finds the leftmost (first) occurrence of target using binary search
     * 
     * Algorithm:
     * 1. Use binary search to find target
     * 2. When target is found, continue searching left half to find first occurrence
     * 3. Keep track of the leftmost position where target was found
     * 
     * @param nums Sorted array
     * @param target Value to search for
     * @return Index of first occurrence or -1 if not found
     */
    private static int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstPosition = -1;  // Track the leftmost position
        
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Prevents integer overflow
            
            if (nums[mid] == target) {
                // Found target, but continue searching left half for first occurrence
                firstPosition = mid;  // Update the position
                right = mid - 1;      // Search left half
            } else if (nums[mid] < target) {
                // Target is in the right half
                left = mid + 1;
            } else {
                // Target is in the left half
                right = mid - 1;
            }
        }
        
        return firstPosition;
    }

    public static int findFirstPositionRecursive(int[] arr, int target, int low, int high){
        if(low>high) return -1;
        int mid=low+(high-low)/2;
        if(arr[mid]==target){
            // Check if it's the first occurrence
            if(mid==0 || arr[mid-1]<target){
                return mid;
            } else {
                return findFirstPositionRecursive(arr, target, low, mid-1);
            }
        } else if(arr[mid]<target){
            return findFirstPositionRecursive(arr, target, mid+1, high);
        } else {
            return findFirstPositionRecursive(arr, target, low, mid-1);
        }
    }
    
    /**
     * Finds the rightmost (last) occurrence of target using binary search
     * 
     * Algorithm:
     * 1. Use binary search to find target
     * 2. When target is found, continue searching right half to find last occurrence
     * 3. Keep track of the rightmost position where target was found
     * 
     * @param nums Sorted array
     * @param target Value to search for
     * @return Index of last occurrence or -1 if not found
     */
    private static int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastPosition = -1;  // Track the rightmost position
        
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Prevents integer overflow
            
            if (nums[mid] == target) {
                // Found target, but continue searching right half for last occurrence
                lastPosition = mid;  // Update the position
                left = mid + 1;      // Search right half
            } else if (nums[mid] < target) {
                // Target is in the right half
                left = mid + 1;
            } else {
                // Target is in the left half
                right = mid - 1;
            }
        }
        
        return lastPosition;
    }

    public static int findLastPositionRecustive(int[] arr, int target, int low, int high){
        if(low>high) return -1;
        int mid = low+(high-low)/2;
        if(arr[mid]>target){
            return findLastPositionRecustive(arr, target,low, mid-1);
        }
        else if(arr[mid]<target){
            return findLastPositionRecustive(arr, target, mid+1, high);
        }
        else{
            if(mid==arr.length-1 || arr[mid+1]!=target){
                return mid;
            }
            else{
                return findLastPositionRecustive(arr, target, mid+1, high);
            }
        }
    }
    
    /**
     * Alternative approach: Single binary search to find both positions
     * This method demonstrates a different approach using one binary search
     * 
     * @param nums Sorted array
     * @param target Value to search for
     * @return Array containing [firstPosition, lastPosition] or [-1, -1]
     */
    public static int[] searchRangeAlternative(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        // Find any occurrence of target first
        int anyPosition = binarySearch(nums, target);
        
        if (anyPosition == -1) {
            return new int[]{-1, -1};
        }
        
        // Expand left to find first position
        int first = anyPosition;
        while (first > 0 && nums[first - 1] == target) {
            first--;
        }
        
        // Expand right to find last position
        int last = anyPosition;
        while (last < nums.length - 1 && nums[last + 1] == target) {
            last++;
        }
        
        return new int[]{first, last};
    }
    
    /**
     * Standard binary search to find any occurrence of target
     * 
     * @param nums Sorted array
     * @param target Value to search for
     * @return Index of any occurrence or -1 if not found
     */
    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
} 