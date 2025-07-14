/**
 * 3423. Maximum Difference Between Adjacent Elements in a Circular Array
 * Solved
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given a circular array nums, find the maximum absolute difference between adjacent elements.
 * <p>
 * Note: In a circular array, the first and last elements are adjacent.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,4]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * <p>
 * Because nums is circular, nums[0] and nums[2] are adjacent. They have the maximum absolute difference of |4 - 1| = 3.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-5,-10,-5]
 * <p>
 * Output: 5
 * <p>
 * Explanation:
 * <p>
 * The adjacent elements nums[0] and nums[1] have the maximum absolute difference of |-5 - (-10)| = 5.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */

public class MaxDifferenceBetweenAdjacentElements {

    public static void main(String[] args) {

    }

    public int maxAdjacentDistance(int[] nums) {
        int max = nums[nums.length - 1] - nums[0];
        if (max < 0) max = -max;
        for (int i = 1; i < nums.length; i++) {
            int a = nums[i - 1] - nums[i];
            if (a < 0) a = -a;
            max = Math.max(max, a);
        }
        return max;

    }

}
