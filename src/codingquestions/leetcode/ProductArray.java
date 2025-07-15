package codingquestions.leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * <p>
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 **/


public class ProductArray {
    public int[] productExceptSelf(int[] nums) {

        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);
        int curr = 1;
        for (int j = 0; j < nums.length; j++) {
            arr[j] *= curr;
            curr *= nums[j];
        }

        curr = 1;
        for (int i = nums.length - 1; i > -1; i--) {

            arr[i] *= curr;
            curr *= nums[i];
        }
        return arr;

    }
}
