import java.util.HashMap;
import java.util.Map;

/**
169. Majority Element
Solved
Easy
Topics
Companies
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

**/
class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer,Integer> a = new HashMap<>();
        int b = nums.length/2;
        for(int i:nums){
            a.put(i,a.getOrDefault(i,0)+1);
            if(a.get(i)>b) return i;
        }
        return 0;
    }
}
