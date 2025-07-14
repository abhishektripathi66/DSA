/**
 * 189. Rotate Array
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 **/

/**
 * we use remainder.
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 9
 * To explain the algorithm first, it performs three reverse operations.
 * <p>
 * First of all, we reverse all numbers.
 * <p>
 * [1,2,3,4,5,6,7]
 * ↓
 * [7,6,5,4,3,2,1]
 * Then, we create two groups like solution 2. Before k and After k.
 * <p>
 * k
 * [7,6,5,4,3,2,1]
 * # # * * * * *
 * <p>
 * k is remainder
 * Then, reverse all numbers in each group.
 * <p>
 * k
 * [7,6,5,4,3,2,1]
 * # # * * * * *
 * ↓
 * k
 * [6,7,1,2,3,4,5]
 * # # * * * * *
 * [6,7,1,2,3,4,5] is actually answer.
 * <p>
 * To summarize the algorithm, we use 3 reverse operation.
 * <p>
 * reverse(0, last index) → whole array
 * reverse(0, k - 1) → before k
 * reverse(k, last index) → after k
 * Let's see solution codes!
 * <p>
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 **/
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
