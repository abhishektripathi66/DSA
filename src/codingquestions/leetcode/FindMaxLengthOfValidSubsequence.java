package codingquestions.leetcode;
/**
 * 3201. Find the Maximum Length of Valid Subsequence I
Medium
You are given an integer array nums.
A subsequence sub of nums with length x is called valid if it satisfies:

(sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
Return the length of the longest valid subsequence of nums.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

Example 1:
Input: nums = [1,2,3,4]
Output: 4
Explanation:
The longest valid subsequence is [1, 2, 3, 4].

Example 2:
Input: nums = [1,2,1,1,2,1,2]
Output: 6
Explanation:
The longest valid subsequence is [1, 2, 1, 2, 1, 2].

Example 3:
Input: nums = [1,3]
Output: 2
Explanation:
The longest valid subsequence is [1, 3].

Constraints:
2 <= nums.length <= 2 * 105
1 <= nums[i] <= 107

 */
public class FindMaxLengthOfValidSubsequence {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int oddCount = (nums[0] % 2 == 1) ? 1 : 0;
        int evenCount = (nums[0] % 2 == 0) ? 1 : 0;
        int alternateCount = 1;
        boolean expectingEven = (nums[0] % 2 == 1);

        for (int i = 1; i < n; ++i) {
            if ((expectingEven && nums[i] % 2 == 0) || (!expectingEven && nums[i] % 2 == 1)) {
                alternateCount++;
                expectingEven = !expectingEven;
            }

            if (nums[i] % 2 == 1) {
                oddCount++;
            } else {
                evenCount++;
            }
        }

        return Math.max(Math.max(evenCount, oddCount), alternateCount);
    }
}
