package codingquestions.leetcode;

import java.util.Arrays;

/**
 * You are given an integer array nums and an integer k.
 * <p>
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * <p>
 * Return the maximum number of operations you can perform on the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 * Example 2:
 * <p>
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 **/

public class MaxKPairs {
    public int maxOperations(int[] nums, int k) {
        int res = 0;
        int l = 0;
        int r;
        int ind = 0;
        for (int i : nums)
            if (i < k) nums[ind++] = i;
        Arrays.sort(nums, 0, ind);
        r = ind - 1;
        while (l < r) {
            if (nums[l] + nums[r] == k) {
                res++;
                l++;
                r--;
            } else if (nums[l] + nums[r] < k) l++;
            else if (nums[l] + nums[r] > k) r--;
        }
        return res;
    }
}
