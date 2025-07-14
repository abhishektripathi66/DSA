package codingquestions.leetcode;

/**
 * 2461. Maximum Sum of Distinct Subarrays With Length K
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
 * <p>
 * The length of the subarray is k, and
 * All the elements of the subarray are distinct.
 * Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,5,4,2,9,9,9], k = 3
 * Output: 15
 * Explanation: The subarrays of nums with length 3 are:
 * - [1,5,4] which meets the requirements and has a sum of 10.
 * - [5,4,2] which meets the requirements and has a sum of 11.
 * - [4,2,9] which meets the requirements and has a sum of 15.
 * - [2,9,9] which does not meet the requirements because the element 9 is repeated.
 * - [9,9,9] which does not meet the requirements because the element 9 is repeated.
 * We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
 * Example 2:
 * <p>
 * Input: nums = [4,4,4], k = 3
 * Output: 0
 * Explanation: The subarrays of nums with length 3 are:
 * - [4,4,4] which does not meet the requirements because the element 4 is repeated.
 * We return 0 because no subarrays meet the conditions.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */

public class MaximumSumofDistinctSubarraysWithLengthK {

    public static void main(String[] args) {
        MaximumSumofDistinctSubarraysWithLengthK msd = new MaximumSumofDistinctSubarraysWithLengthK();
        System.out.println(msd.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
    }

    public long maximumSubarraySum(int[] nums, int k) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int[] counts = new int[maxNum + 1];
        int dupCount = 0;
        long totalSum = 0;
        long curSum = 0;
        for (int i = 0; i < k; i++) {
            if (counts[nums[i]] >= 1) {
                dupCount++;
            }
            counts[nums[i]]++;
            curSum += nums[i];
        }
        if (dupCount == 0) {
            totalSum = curSum;
        }
        for (int i = k; i < nums.length; i++) {
            if (counts[nums[i]] >= 1) {
                dupCount++;
            }
            counts[nums[i]]++;
            curSum += nums[i];
            if (counts[nums[i - k]] > 1) {
                dupCount--;
            }
            counts[nums[i - k]]--;
            curSum -= nums[i - k];
            if (dupCount == 0) {
                totalSum = Math.max(totalSum, curSum);
            }
        }
        return totalSum;
    }
}
