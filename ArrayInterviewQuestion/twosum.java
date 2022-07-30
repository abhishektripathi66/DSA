package ArrayInterviewQuestion;

import java.lang.reflect.Method;
import java.util.Arrays;

//Write a program to find all pairs of integers whose sum is equal to a given number.

//Examples

//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1]
public class twosum {
    
    public static void main(String[] args) {
        twosum ts = new twosum();
        int nums[] = {2,7,11,15};
        System.out.println(Arrays.toString(ts.sumofTwo(nums, 5))); 
    }

    public int[] sumofTwo(int nums[],int target){

        int[] pair = new int[2];
        for(int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                    pair[0]=i;pair[1]=j;
                    return pair;
                }
            }
        }
        throw new IllegalArgumentException("No solution found who's sum is "+target);
    }
}
