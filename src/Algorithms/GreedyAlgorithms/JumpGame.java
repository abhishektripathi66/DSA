package GreedyAlgorithms;

/*
 * Jump Game to find minimum jumps to reach end
 * 
 * Given an array of positive integer where each index represents maximum jump can be made from that index.
 * Find minimum jumps to reach at the end of array or beyond that.
 * 
 * In this solution greedy approach is used. It can solved using dp as well, but in that time complextiy will be O(n^2).
 *
 * Time Complexity: O(n)
 * Auxilliary Space Complexity: O(1)
 *
 * Example:
 *   nums = [2,3,1,1,4] → Max value = 240.0
 */


public class JumpGame {
    public static void main(String[] args){
        int[] nums = {2,3,1,1,4};
        System.out.println("Min Jumps : "+minJump(nums));
    }

    private static int minJump(int[] nums) {
        //greedy approach
        int n = nums.length;
        int near = 0, far = 0, jumps = 0;

        while(far < n-1){ //try until far has not reached end index
            int farthest = 0;

            for(int i=near; i<=far; i++){
                //possible farthest jump from curr idx
                farthest = Math.max(farthest, i + nums[i]); 
            }

            //try from next window where current jump is made
            near = far + 1; 
            far = farthest;

            //increament for current jump
            jumps++;
        }

        return jumps;
    }
}
