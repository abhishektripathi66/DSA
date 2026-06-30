/*
3507. Minimum Pair Removal to Sort Array I
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given an array nums, you can perform the following operation any number of times:

Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.
Replace the pair with their sum.
Return the minimum number of operations needed to make the array non-decreasing.

An array is said to be non-decreasing if each element is greater than or equal to its previous element (if it exists).

 

Example 1:

Input: nums = [5,2,3,1]

Output: 2

Explanation:

The pair (3,1) has the minimum sum of 4. After replacement, nums = [5,2,4].
The pair (2,4) has the minimum sum of 6. After replacement, nums = [5,6].
The array nums became non-decreasing in two operations.

Example 2:

Input: nums = [1,2,2]

Output: 0

Explanation:

The array nums is already sorted.

 

Constraints:

1 <= nums.length <= 50
-1000 <= nums[i] <= 1000
*/
class Solution {
    public int minimumPairRemoval(int[] nums) {
        int res = 0;
        while(true){
            boolean flag = true;
            for(int i = 1; i < nums.length; i++)
                if(nums[i - 1] > nums[i]){
                    flag = false;
                    break;
                }
            if(flag) break;
            res++;
            
            int minSum = (int)1e9;
            for(int i = 1; i < nums.length; i++) minSum = Math.min(minSum, nums[i - 1] + nums[i]);
            for(int i = 1; i < nums.length; i++){
                if(nums[i - 1] + nums[i] != minSum) continue;
                int[] newNums = new int[nums.length - 1];
                for(int j = 0; j < i - 1; j++) newNums[j] = nums[j];
                newNums[i - 1] = nums[i - 1] + nums[i];
                for(int j = i + 1; j < nums.length; j++) newNums[j - 1] = nums[j];
                nums = newNums;
                break;
            }
        }
        return res;
    }
}
