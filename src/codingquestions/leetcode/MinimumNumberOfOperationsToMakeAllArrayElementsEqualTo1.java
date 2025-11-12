/*
2654. Minimum Number of Operations to Make All Array Elements Equal to 1
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given a 0-indexed array nums consisiting of positive integers. You can do the following operation on the array any number of times:

Select an index i such that 0 <= i < n - 1 and replace either of nums[i] or nums[i+1] with their gcd value.
Return the minimum number of operations to make all elements of nums equal to 1. If it is impossible, return -1.

The gcd of two integers is the greatest common divisor of the two integers.

 

Example 1:

Input: nums = [2,6,3,4]
Output: 4
Explanation: We can do the following operations:
- Choose index i = 2 and replace nums[2] with gcd(3,4) = 1. Now we have nums = [2,6,1,4].
- Choose index i = 1 and replace nums[1] with gcd(6,1) = 1. Now we have nums = [2,1,1,4].
- Choose index i = 0 and replace nums[0] with gcd(2,1) = 1. Now we have nums = [1,1,1,4].
- Choose index i = 2 and replace nums[3] with gcd(1,4) = 1. Now we have nums = [1,1,1,1].
Example 2:

Input: nums = [2,10,6,14]
Output: -1
Explanation: It can be shown that it is impossible to make all the elements equal to 1.
 

Constraints:

2 <= nums.length <= 50
1 <= nums[i] <= 106
*/
class Solution {
    private int getGCD(int a, int b){
        while(b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public int minOperations(int[] nums) {
        int gcd = nums[0], cnt1 = 0;
        for(int i = 0; i < nums.length; i++){
            gcd = getGCD(gcd, nums[i]);
            if(nums[i] == 1)
                cnt1++;
        }
        
        if(gcd != 1)
            return -1;
        
        if(cnt1 > 0)
            return nums.length - cnt1;
        
        int res = nums.length * 2;
        for(int i = 0; i < nums.length; i++){
            gcd = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                gcd = getGCD(gcd, nums[j]);
                if(gcd == 1){
                    res = Math.min(res, j - i + nums.length - 1);
                    break;
                }
            }
        }

        return res;
    }
}
