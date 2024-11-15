/**
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

 

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 

**/


public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        
        
        if(nums == null || nums.length<3 ) return false;
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for(int num:nums){
// used to get the first minimum value
            if(num<=a){
                a=num;
            }
// used to get the second minimum value
            else if(num<=b){
                b=num;
            }
// if found 3rd value then return true;
            else{
                return true;
            }
        }
        return false;
            
            
        }
        
}
