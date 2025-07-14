package codingquestions.leetcode;

/*
2444. Count Subarrays With Fixed Bounds
Solved
Hard
Topics
Companies
Hint
You are given an integer array nums and two integers minK and maxK.

A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

The minimum value in the subarray is equal to minK.
The maximum value in the subarray is equal to maxK.
Return the number of fixed-bound subarrays.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
Output: 2
Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
Example 2:

Input: nums = [1,1,1,1], minK = 1, maxK = 1
Output: 10
Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
 

Constraints:

2 <= nums.length <= 105
1 <= nums[i], minK, maxK <= 106
*/

import java.util.Vector;

public class CountSubarraysWithFixedBounds {

    long countHelper(Vector<Integer> v, boolean isEqual) {
        //|1| + |2| - (|1| OR |2|)
        int n = v.size();
        long res = 0;

        if (isEqual) {
            int j = -1;
            for (int i = 0; i < n; i++) {
                if (v.get(i) == 1 || v.get(i) == 2) {
                    res += (long) (i - j) * (n - i);
                    j = i;
                }
            }
            return res;
        }

        //|1|
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (v.get(i) == 1) {
                //l: from j + 1 to i
                //r: from i to n - 1
                res += (long) (i - j) * (n - i);
                j = i;
            }
        }

        //|2|
        j = -1;
        for (int i = 0; i < n; i++) {
            if (v.get(i) == 2) {
                //l: from j + 1 to i
                //r: from i to n - 1
                res += (long) (i - j) * (n - i);
                j = i;
            }
        }

        //|1 OR 2|
        j = -1;
        for (int i = 0; i < n; i++) {
            if (v.get(i) == 1 || v.get(i) == 2) {
                //l: from j + 1 to i
                //r: from i to n - 1
                res -= (long) (i - j) * (n - i);
                j = i;
            }
        }
        return res;
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        Vector<Integer> left = new Vector<Integer>();
        Vector<Integer> right = new Vector<Integer>();
        int l = 0;
        while (l < n && (nums[l] > maxK || nums[l] < minK))
            l++;

        if (l == n) return 0;

        boolean flag = true;
        for (int r = l; r < n; r++) {
            if (minK <= nums[r] && nums[r] <= maxK) {
                if (!flag) {
                    l = r;
                    flag = true;
                }
                continue;
            }
            //nums[r] > maxK || nums[r] < minK
            if (flag) {
                left.add(l);
                right.add(r - 1);
                flag = false;
            }
        }
        if (flag) {
            left.add(l);
            right.add(n - 1);
        }

        long res = 0;
        for (int i = 0; i < left.size(); i++) {
            int getLeft = left.get(i);
            int getRight = right.get(i);
            Vector<Integer> interval = new Vector<Integer>();
            for (int j = getLeft; j <= getRight; j++) {
                if (nums[j] == minK) interval.add(1);
                else if (nums[j] == maxK) interval.add(2);
                else interval.add(0);
            }
            res += countHelper(interval, minK == maxK);
        }

        return res;
    }
}
