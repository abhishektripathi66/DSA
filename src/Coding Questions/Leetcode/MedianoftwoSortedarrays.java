/*4. Median of Two Sorted Arrays
 Hard
 Topics
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
 0 <= m <= 1000*/

 /*-Intuition
 The goal of the problem is to find the median of two sorted arrays. A naive approach would be to combine both arrays into one, sort the combined array, and then find the median.
 The intuition behind this solution is straightforward: since the input arrays are sorted, combining and sorting them ensures we have a unified sorted array from which the median
 can be easily calculated.
 -Approach
 *Combine both arrays into one by copying the elements of both nums1 and nums2 into a new array nums.
 *Sort the merged array nums.
 *If the length of the array is odd, the median is the middle element. If it's even, the median is the average of the two middle elements.
 Return the computed median value.*/

//Code-
import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums[] = new int[nums1.length + nums2.length];
        for(int i=0; i<nums1.length; i++){
            nums[i] = nums1[i];
        }
        for(int i=0; i<nums2.length; i++){
            nums[i + nums1.length] = nums2[i];
        }
        Arrays.sort(nums);
        double x = 0;
        if(nums.length%2==0){
            double w = nums[nums.length/2 - 1];
            double y = nums[nums.length/2];
            x = (w+y)/2;
        }
        else{
            x = nums[nums.length/2];
        }
        return x;
    }
}

