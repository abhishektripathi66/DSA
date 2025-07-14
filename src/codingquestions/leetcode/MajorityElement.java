package codingquestions.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 * 
 * 
 */

public class MajorityElement {

    public static void main(String[] args) {
        var me = new MajorityElement();
        me.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }

    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> x = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (x.get(nums[i]) == null) x.put(nums[i], 1);
            else {
                x.put(nums[i], x.get(nums[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : x.entrySet()) {

            if (entry.getValue() > nums.length / 2) return entry.getKey();

        }

        return -1;
    }
}
