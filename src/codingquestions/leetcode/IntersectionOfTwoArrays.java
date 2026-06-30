/*
349. Intersection of Two Arrays
Solved
Easy
Topics
premium lock icon
Companies
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] exists = new int[1001];
        for(int i : nums1)
            exists[i] |= 1;
        for(int i : nums2)
            exists[i] |= 2;
        int cnt = 0;
        for(int i : exists)
            cnt += (i == 3 ? 1 : 0);
        
        int[] res = new int[cnt];
        cnt = 0;
        for(int i = 0; i < exists.length; i++)
            if(exists[i] == 3)
                res[cnt++] = i;
        return res;
    }
}
