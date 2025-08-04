package codingquestions.leetcode;

/**
1695. Maximum Erasure Value
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

 

Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].
Example 2:

Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
  **/
public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {

        int[] lastIndex = new int[10001];
        for (int i = 0; i < lastIndex.length; i++) {
            lastIndex[i] = -1;
        }
        int l = -1, sum = 0;
        int[] prefixSum = new int[nums.length+1];

        for (int r = 0; r < nums.length; r++) {
            prefixSum[r+1] = nums[r] + prefixSum[r];
            if (lastIndex[nums[r]] >= 0) {
                l = Math.max(l, lastIndex[nums[r]]);
            }
            sum = Math.max(sum, prefixSum[r+1] - prefixSum[l+1]);
            lastIndex[nums[r]] = r;
        }

        return sum;
        
    }
}

// NEW SOLUTION
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] cnt = new int[10007];
        int r = 0;
        int cur_sum = 0;
        while(r < nums.length && cnt[nums[r]] < 1){
            cnt[nums[r]]++;
            cur_sum += nums[r];
            r++;
        }

        int res = cur_sum, l = 0;

        for(; r < nums.length; r++){
            cnt[nums[r]]++;
            cur_sum += nums[r];
            while(cnt[nums[r]] > 1){
                cur_sum -= nums[l];
                cnt[nums[l]]--;
                l++;
            }
            res = Math.max(res, cur_sum);
        }
        return res;
    }
}
