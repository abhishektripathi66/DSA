import java.util.Arrays;

/**
 * 16. 3Sum Closest
 Solved
 Medium
 Topics
 Companies
 Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 
 Return the sum of the three integers.
 
 You may assume that each input would have exactly one solution.
 **/

 public class SumClosest3{

    public static void main(String[] args) {
        SumClosest3 s = new SumClosest3();
        System.out.println(s.threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }
        public int threeSumClosest(int[] nums, int target) {

                Arrays.sort(nums);
                int closeSum= Integer.MAX_VALUE/2;
                for(int i=0;i<nums.length-2;++i){
                    int left = i+1,right=nums.length-1;
                int min_sum = nums[i] + nums[i+1] + nums[i+2];
                    if(min_sum >= target + Math.abs(target - closeSum)) return closeSum;
                    while(left<right){
                    int currentSum = nums[i]+nums[left]+nums[right];
                    if(Math.abs(currentSum-target)<Math.abs(closeSum-target))
                    closeSum=currentSum;
                    if(currentSum<target) ++left;
                    else if (currentSum>target) --right;
                    else return currentSum;
                    }
                }
                return  closeSum;
            }
 }