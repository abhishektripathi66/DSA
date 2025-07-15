package codingquestions.leetcode;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 **/

public class MaxConsecutive {
    public int longestOnes(int[] nums, int k) {

        int left = 0, right = 0, max = 0, kc = k;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                right++;
            } else {
                if (kc > 0) {
                    right++;
                    kc--;
                } else {
                    max = Math.max(max, right - left);

                    while (left < nums.length && nums[left] == 1) {
                        left++;
                    }

                    left++;

                    right++;
                }
            }

        }


        max = Math.max(max, right - left);

        return max;

    }
}
