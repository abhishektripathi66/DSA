/*
594. Longest Harmonious Subsequence
Solved
Easy
Topics
premium lock icon
Companies
We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

 

Example 1:

Input: nums = [1,3,2,2,5,2,3,7]

Output: 5

Explanation:

The longest harmonious subsequence is [3,2,2,2,3].

Example 2:

Input: nums = [1,2,3,4]

Output: 2

Explanation:

The longest harmonious subsequences are [1,2], [2,3], and [3,4], all of which have a length of 2.

Example 3:

Input: nums = [1,1,1,1]

Output: 0

Explanation:

No harmonic subsequence exists.

 

Constraints:

1 <= nums.length <= 2 * 104
-109 <= nums[i] <= 109
*/

import java.util.Arrays;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int r = 1;
        int res = 0;
        for (int l = 0; l < nums.length - 1; l++) {
            while (r < nums.length && nums[r] - nums[l] < 1)
                r++;

            if (r == nums.length)
                break;

            if (nums[r] == nums[l] + 1) {
                while (r < nums.length - 1 && nums[r] == nums[r + 1])
                    r++;

                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }
}
