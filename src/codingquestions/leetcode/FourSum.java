package codingquestions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
18.4Sum
Medium
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 
Constraints:
1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < n-1; i++) {
             if (i > 0 && nums[i] == nums[i - 1]) {
                     continue;
                 }
            for (int j = (i + 1); j < n; j++) {
                if (j > (i+1) && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        // System.out.println("i: "+i+" j: "+j+" l: "+l+" r: "+ r);
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // After finding triplet, moving the l alone to the next element
                        // Since same i, diff l, same r will be a diff combination
                        l++;

                        // Moved l should also be diff from previous, to prevent same triplets
                        while (l < r && nums[l] == nums[l - 1])
                            l++;
                    } 
                    else if (sum < target) {
                        l++;
                    } 
                    else {
                        r--;
                    }
                }
            }
        }
        return result;
    }
}
