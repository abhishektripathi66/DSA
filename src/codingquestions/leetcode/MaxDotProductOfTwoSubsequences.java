/*
1458. Max Dot Product of Two Subsequences
Solved
Hard
Topics
premium lock icon
Companies
Hint
Given two arrays nums1 and nums2.

Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.

A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).

 

Example 1:

Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
Output: 18
Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
Their dot product is (2*3 + (-2)*(-6)) = 18.
Example 2:

Input: nums1 = [3,-2], nums2 = [2,-6,7]
Output: 21
Explanation: Take subsequence [3] from nums1 and subsequence [7] from nums2.
Their dot product is (3*7) = 21.
Example 3:

Input: nums1 = [-1,-1], nums2 = [1,1]
Output: -1
Explanation: Take subsequence [-1] from nums1 and subsequence [1] from nums2.
Their dot product is -1.
 

Constraints:

1 <= nums1.length, nums2.length <= 500
-1000 <= nums1[i], nums2[i] <= 1000
*/
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        // dp[flag][i][j]: max when consider nums1[0...i], nums2[0...j], flag = taken at least 1 element or not
        int m = nums1.length, n = nums2.length;
        int[][][] dp = new int[2][m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            for(int j = 0; j <= n; j++)
                dp[1][i][j] = -(int)1e9;
        
        int res = -(int)1e9;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                res = Math.max(res, nums1[i - 1] * nums2[j - 1]);
                dp[1][i][j] = Math.max(0, dp[1][i - 1][j - 1]) + nums1[i - 1] * nums2[j - 1];
                dp[1][i][j] = Math.max(dp[1][i][j], Math.max(dp[1][i - 1][j], dp[1][i][j - 1]));
                res = Math.max(res, dp[1][i][j]);
            }
        }
        return res;
    }
}
