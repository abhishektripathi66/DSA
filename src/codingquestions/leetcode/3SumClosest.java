/*
16. 3Sum Closest
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104
*/
class Solution {
    private int binary_search(int[] nums, int target, int l, int r){
        int mid;
        while(l <= r){
            mid = (l + r) >> 1;
            if(nums[mid] == target)
                return mid;

            if(nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        // r < l
        return r;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int dist = 1000000000;
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                // potential: a[k] = target - a[i] - a[j]
                int k = binary_search(nums, target - nums[i] - nums[j], j + 1, n - 1);

                if(k > j){
                    if(Math.abs(target - nums[i] - nums[j] - nums[k]) < dist){
                        dist = Math.abs(target - nums[i] - nums[j] - nums[k]);
                        res = nums[i] + nums[j] + nums[k];
                    }
                }

                if(k != n - 1){
                    if(Math.abs(target - nums[i] - nums[j] - nums[k + 1]) < dist){
                        dist = Math.abs(target - nums[i] - nums[j] - nums[k + 1]);
                        res = nums[i] + nums[j] + nums[k + 1];
                    }       
                }
            }
        }
        return res;
    }
}
