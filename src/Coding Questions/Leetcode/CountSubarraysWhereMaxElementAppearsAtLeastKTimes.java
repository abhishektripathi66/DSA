/*
2962. Count Subarrays Where Max Element Appears at Least K Times
Solved
Medium
Topics
Companies
You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

A subarray is a contiguous sequence of elements within an array.

 

Example 1:

Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
Example 2:

Input: nums = [1,4,2,1], k = 3
Output: 0
Explanation: No subarray contains the element 4 at least 3 times.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 106
1 <= k <= 105
*/
import java.util.Vector;
class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        Vector<Integer> dp = new Vector<Integer> ();
        dp.add(0);
        
        int maxElt = 0;
        for(int i = 0; i < n; i++) maxElt = Math.max(maxElt, nums[i]);
        dp.add(nums[0] == maxElt ? 1 : 0);
        for(int i = 1; i < n; i++) dp.add(dp.get(i) + (nums[i] == maxElt ? 1 : 0));
        
        int pt = 1;
        long res = 0;
        for(int i = 1; i <= n; i++){
            while(pt + 1 <= n && dp.get(pt) - dp.get(i - 1) < k) pt++;
            if(dp.get(pt) - dp.get(i - 1) >= k) res += (n - pt + 1);
        }
        return res;
    }
}
