/*
1498. Number of Subsequences That Satisfy the Given Sum Condition
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
[3] -> Min value + max value <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
[3,5,6] -> (3 + 6 <= 9)
[3,6] -> (3 + 6 <= 9)
Example 2:

Input: nums = [3,3,6,8], target = 10
Output: 6
Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
Example 3:

Input: nums = [2,3,3,4,6,7], target = 12
Output: 61
Explanation: There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]).
Number of valid subsequences (63 - 2 = 61).
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 106
1 <= target <= 106
*/
class Solution {
    private final int MOD = 1000000007;

    int powerOf(int a, int b){
        if(b == 0)
            return 1;
        
        if(b == 1)
            return a;
        
        long res = powerOf(a, b >> 1);
        res = (res * res) % MOD;
        if(b % 2 != 0)
            res = (res * a) % MOD;
        
        return (int)res;
    }

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int rightIdx = nums.length - 1;
        int res = 0;
        
        for(int leftIdx = 0; leftIdx <= rightIdx; leftIdx++){
            while(rightIdx >= 0 && nums[leftIdx] + nums[rightIdx] > target)
                rightIdx--;
            
            if(leftIdx > rightIdx)
                break;
            
            //count
            res = (res + powerOf(2, rightIdx - leftIdx)) % MOD;
        }
        return res;
    }
}
