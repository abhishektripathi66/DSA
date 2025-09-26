package codingquestions.leetcode;

/*
1493. Longest Subarray of 1's After Deleting One Element
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

 

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
*/
class LongestSubarrayOf1sAfterDeletingOneElement {
    private int sumOf(int l, int r, int[] dp){
        return dp[r + 1] - dp[l];
    }

    public int longestSubarray(int[] nums) {
        for(int i = 0; i < nums.length; i++)
            nums[i] = 1 - nums[i];
        
        int[] prefSum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++)
            prefSum[i] = prefSum[i - 1] + nums[i - 1];
        
        int l = 0;
        int res = 0;
        for(int r = 0; r < nums.length; r++){
            while(sumOf(l, r, prefSum) > 1)
                l++;
            
            res = Math.max(res, r - l);
        }

        return res;
    }
}
