package Leetcode;

public class PivotIndex {


 public int pivotIndex(int[] nums) {
        // int sumRight=0;
        int sumLeft=0;
        int sum=0;

        // get the total sums
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        //reduce index i from the sum which makes it right sum and add it in the left sum
        for(int i=0;i<nums.length;i++){
            sum-=nums[i];
            if(sum==sumLeft){
                return i;
            }
            sumLeft+=nums[i];
        }
        return -1;
    }



}
