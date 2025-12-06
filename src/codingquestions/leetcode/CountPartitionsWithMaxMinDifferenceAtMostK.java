/*
3578. Count Partitions With Max-Min Difference at Most K
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an integer array nums and an integer k. Your task is to partition nums into one or more non-empty contiguous segments such that in each segment, the difference between its maximum and minimum elements is at most k.

Return the total number of ways to partition nums under this condition.

Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: nums = [9,4,1,3,7], k = 4

Output: 6

Explanation:

There are 6 valid partitions where the difference between the maximum and minimum elements in each segment is at most k = 4:

[[9], [4], [1], [3], [7]]
[[9], [4], [1], [3, 7]]
[[9], [4], [1, 3], [7]]
[[9], [4, 1], [3], [7]]
[[9], [4, 1], [3, 7]]
[[9], [4, 1, 3], [7]]
Example 2:

Input: nums = [3,3,4], k = 0

Output: 2

Explanation:

There are 2 valid partitions that satisfy the given conditions:

[[3], [3], [4]]
[[3, 3], [4]]
 

Constraints:

2 <= nums.length <= 5 * 104
1 <= nums[i] <= 109
0 <= k <= 109
*/
class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n + 2];
        long[] prefSum = new long[n + 2]; // prefSum[i] = Sum(dp[1...i])
        long MOD = (long)1e9 + 7L;

        dp[0] = 1;
        prefSum[0] = 1;
        TreeMap<Integer, Integer> elements = new TreeMap<>();
        int l = 0;
        for(int i = 0; i < n; i++){
            elements.put(nums[i], elements.getOrDefault(nums[i], 0) + 1);

            while(l <= i && elements.lastKey() - elements.firstKey() > k){
                elements.put(nums[l], elements.getOrDefault(nums[l], 0) - 1);
                if(elements.get(nums[l]) == 0)
                    elements.remove(nums[l]);
                
                l++;
            }

            dp[i + 1] = (prefSum[i] - (l > 0 ? prefSum[l - 1] : 0)) % MOD;
            prefSum[i + 1] = prefSum[i] + dp[i + 1] % MOD;
        }
        if(dp[n] < 0)
            dp[n] += MOD;
        
        return (int)dp[n];
    }
}
