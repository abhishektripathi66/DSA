package codingquestions.leetcode;

import java.util.Arrays;

/*
3480. Maximize Subarrays After Removing One Conflicting Pair
Solved
Hard
Topics
premium lock icon
Companies
Hint
You are given an integer n which represents an array nums containing the numbers from 1 to n in order. Additionally, you are given a 2D array conflictingPairs, where conflictingPairs[i] = [a, b] indicates that a and b form a conflicting pair.

Remove exactly one element from conflictingPairs. Afterward, count the number of non-empty subarrays of nums which do not contain both a and b for any remaining conflicting pair [a, b].

Return the maximum number of subarrays possible after removing exactly one conflicting pair.

 

Example 1:

Input: n = 4, conflictingPairs = [[2,3],[1,4]]

Output: 9

Explanation:

Remove [2, 3] from conflictingPairs. Now, conflictingPairs = [[1, 4]].
There are 9 subarrays in nums where [1, 4] do not appear together. They are [1], [2], [3], [4], [1, 2], [2, 3], [3, 4], [1, 2, 3] and [2, 3, 4].
The maximum number of subarrays we can achieve after removing one element from conflictingPairs is 9.
Example 2:

Input: n = 5, conflictingPairs = [[1,2],[2,5],[3,5]]

Output: 12

Explanation:

Remove [1, 2] from conflictingPairs. Now, conflictingPairs = [[2, 5], [3, 5]].
There are 12 subarrays in nums where [2, 5] and [3, 5] do not appear together.
The maximum number of subarrays we can achieve after removing one element from conflictingPairs is 12.
 

Constraints:

2 <= n <= 105
1 <= conflictingPairs.length <= 2 * n
conflictingPairs[i].length == 2
1 <= conflictingPairs[i][j] <= n
conflictingPairs[i][0] != conflictingPairs[i][1]
*/
public class MaximizeSubarraysAfterRemovingOneConflictingPair {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        int[] bMin1 = new int[n + 1];
        int[] bMin2 = new int[n + 1];
        Arrays.fill(bMin1, Integer.MAX_VALUE);
        Arrays.fill(bMin2, Integer.MAX_VALUE);
        for (int[] pair : conflictingPairs) {
            int a = Math.min(pair[0], pair[1]);
            int b = Math.max(pair[0], pair[1]);
            if (bMin1[a] > b) {
                bMin2[a] = bMin1[a];
                bMin1[a] = b;
            } else if (bMin2[a] > b) {
                bMin2[a] = b;
            }
        }
        long res = 0;
        int ib1 = n;
        int b2 = Integer.MAX_VALUE;
        long[] delCount = new long[n + 1];
        for (int i = n; i >= 1; i--) {
            if (bMin1[ib1] > bMin1[i]) {
                b2 = Math.min(b2, bMin1[ib1]);
                ib1 = i;
            } else {
                b2 = Math.min(b2, bMin1[i]);
            }
            res += Math.min(bMin1[ib1], n + 1) - i;
            delCount[ib1] +=
                Math.min(Math.min(b2, bMin2[ib1]), n + 1) -
                Math.min(bMin1[ib1], n + 1);
        }
        long max = 0;
        for (long val : delCount) {
            max = Math.max(max, val);
        }
        return res + max;
    }
}
