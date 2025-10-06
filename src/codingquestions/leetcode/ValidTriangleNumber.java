package codingquestions.leetcode;
import java.util.*;
/*
611. Valid Triangle Number
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

 

Example 1:

Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Example 2:

Input: nums = [4,2,3,4]
Output: 4
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 1000
*/
class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int r = i;
            for(int l = i + 1; l < nums.length; l++){
                r = Math.max(r, l + 1);
                
                while(r < nums.length && nums[i] + nums[l] > nums[r])
                    r++;
                
                r--;
                if(l < r)
                    res += (r - l);
            }
        }

        return res;
    }
}
