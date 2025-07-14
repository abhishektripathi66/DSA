package codingquestions.leetcode;

/**
 * Given a binary array nums, you should delete one element from it.
 * <p>
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 * Example 2:
 * <p>
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 * Example 3:
 * <p>
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 **/

public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        int count = 0, prevCount = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                res = Math.max(res, count + prevCount);
                prevCount = count;
                count = 0;
            }
        }

        res = Math.max(res, count + prevCount);
        return res == nums.length ? res - 1 : res;


    }
}
