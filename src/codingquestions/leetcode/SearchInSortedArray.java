package codingquestions.leetcode;

/*
 * 
 * There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1

Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
Memory Usage: 42.9 MB, less than 32.59% of Java online submissions for Search in Rotated Sorted Array.
 * 
 */
public class SearchInSortedArray {

    public static void main(String[] args) {
        var sisa = new SearchInSortedArray();
        System.out.println(sisa.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public int search(int[] nums, int target) {
        int j = nums.length - 1;
        for (int i = 0; i <= nums.length / 2; i++) {
            if (nums[i] == target) return i;
            else if (nums[j] == target) return j;
            j--;
        }
        return -1;
    }
}
