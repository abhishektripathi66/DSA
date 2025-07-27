package codingquestions.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 3487. Maximum Unique Subarray Sum After Deletion
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given an integer array nums.

You are allowed to delete any number of elements from nums without making it empty. After performing the deletions, select a subarray of nums such that:

All elements in the subarray are unique.
The sum of the elements in the subarray is maximized.
Return the maximum sum of such a subarray.

 

Example 1:

Input: nums = [1,2,3,4,5]

Output: 15

Explanation:

Select the entire array without deleting any element to obtain the maximum sum.

Example 2:

Input: nums = [1,1,0,1,1]

Output: 1

Explanation:

Delete the element nums[0] == 1, nums[1] == 1, nums[2] == 0, and nums[3] == 1. Select the entire array [1] to obtain the maximum sum.

Example 3:

Input: nums = [1,2,-1,-2,1,0,-1]

Output: 3

Explanation:

Delete the elements nums[2] == -1 and nums[3] == -2, and select the subarray [2, 1] from [1, 2, 1, 0, -1] to obtain the maximum sum.

 

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100
*/
 
public class MaximumUniqueSubarraySumAfterDeletion {

    public static void main(String[] args) {
        
    }

    public int maxSumUsingArray(int[] nums) {
        int sum =0;
        int[] visited = new int[101];
        int maxnegative=Integer.MIN_VALUE;
        int pos =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                 maxnegative = Math.max(maxnegative,nums[i]);   
            }
            else{
                visited[nums[i]]++;
                if(visited[nums[i]]<=1) sum+=nums[i];
                pos++;
            }
            
        }
        if(pos==0) return maxnegative;
        return sum;
    }

    public int maxSumUsingHashSet(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int num : nums){
            if(num > 0)
                st.add(num);
        }

        if(st.isEmpty()){
            int res = -100;
            for(int num : nums)
                res = Math.max(res, num);
            
            return res;
        }
        int res = 0;
        for(int i : st)
            res += i;
        
        return res;
    }
    
}
