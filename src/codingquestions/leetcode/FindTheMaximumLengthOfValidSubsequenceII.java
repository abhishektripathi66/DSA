package codingquestions.leetcode;

/*
3202. Find the Maximum Length of Valid Subsequence II
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an integer array nums and a positive integer k.
A subsequence sub of nums with length x is called valid if it satisfies:

(sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k.
Return the length of the longest valid subsequence of nums.
 

Example 1:

Input: nums = [1,2,3,4,5], k = 2

Output: 5

Explanation:

The longest valid subsequence is [1, 2, 3, 4, 5].

Example 2:

Input: nums = [1,4,2,3,1,4], k = 3

Output: 4

Explanation:

The longest valid subsequence is [1, 4, 1, 4].

 

Constraints:

2 <= nums.length <= 103
1 <= nums[i] <= 107
1 <= k <= 103
*/
public class FindTheMaximumLengthOfValidSubsequenceII {
    public int maximumLength(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++)
            nums[i] %= k;
        
        int[][] dp = new int[k][k]; // dp[i][j]: the last 2 elements have remainders i and j, respectively
        int res = 0;

        for(int num : nums){
            for(int prev = 0; prev < k; prev++){
                dp[prev][num] = dp[num][prev] + 1;
                res = Math.max(res, dp[prev][num]);
            }
        }
        
        return res;
    }
}
