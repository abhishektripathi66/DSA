/**
3201. Find the Maximum Length of Valid Subsequence I
Solved
Medium
Topics
premium lock icon
Companies
Hint
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
**/


public class FindtheMaximumLengthofValidSubsequenceI {
    public int maximumLength(int[] nums) {
      // count is used to calculate odd and even,; end is used to calculate alternate
        int[] count = new int[2], end = new int[2];

        for (int num : nums) {
            count[num % 2]++;  //odd even
            end[num % 2] = end[1 - num % 2] + 1; //alternate count
        }

      //calculate the max from the odd and even and the alternate;
        return Math.max(
            Math.max(end[0], end[1]),
            Math.max(count[0], count[1])
        );
    }
}
