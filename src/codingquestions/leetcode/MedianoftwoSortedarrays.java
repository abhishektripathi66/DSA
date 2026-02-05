/*
4. Median of Two Sorted Arrays
Solved
Hard
Topics
premium lock icon
Companies
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sz1 = nums1.length, sz2 = nums2.length;
        if(sz1 < sz2)
            return findMedianSortedArrays(nums2, nums1);
        
        // sz1 >= sz2
        // thus, binary search on nums2
        int l = 0, r = sz2 * 2;
        while(l <= r){
            int mid2 = (l + r) >> 1;
            int mid1 = sz1 + sz2 - mid2;

            int l1, l2, r1, r2;
            l1 = (mid1 == 0 ? -1000000000 : nums1[(mid1 - 1) / 2]);
            l2 = (mid2 == 0 ? -1000000000 : nums2[(mid2 - 1) / 2]);
            r1 = (mid1 == sz1 * 2 ? 1000000000 : nums1[mid1 / 2]);
            r2 = (mid2 == sz2 * 2 ? 1000000000 : nums2[mid2 / 2]);

            // recursive cases
            if(l1 > r2){
                l = mid2 + 1;
            } else if(l2 > r1){
                r = mid2 - 1;
            } else
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
        }
        return -123456789;
    }
}
