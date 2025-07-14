package codingquestions.leetcode;

import java.util.List;

/**
 * 3314. Construct the Minimum Bitwise Array I
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given an array nums consisting of n
 * prime
 * integers.
 * <p>
 * You need to construct an array ans of length n, such that, for each index i, the bitwise OR of ans[i] and ans[i] + 1 is equal to nums[i], i.e. ans[i] OR (ans[i] + 1) == nums[i].
 * <p>
 * Additionally, you must minimize each value of ans[i] in the resulting array.
 * <p>
 * If it is not possible to find such a value for ans[i] that satisfies the condition, then set ans[i] = -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,5,7]
 * <p>
 * Output: [-1,1,4,3]
 * <p>
 * Explanation:
 * <p>
 * For i = 0, as there is no value for ans[0] that satisfies ans[0] OR (ans[0] + 1) = 2, so ans[0] = -1.
 * For i = 1, the smallest ans[1] that satisfies ans[1] OR (ans[1] + 1) = 3 is 1, because 1 OR (1 + 1) = 3.
 * For i = 2, the smallest ans[2] that satisfies ans[2] OR (ans[2] + 1) = 5 is 4, because 4 OR (4 + 1) = 5.
 * For i = 3, the smallest ans[3] that satisfies ans[3] OR (ans[3] + 1) = 7 is 3, because 3 OR (3 + 1) = 7.
 * Example 2:
 * <p>
 * Input: nums = [11,13,31]
 * <p>
 * Output: [9,12,15]
 * <p>
 * Explanation:
 * <p>
 * For i = 0, the smallest ans[0] that satisfies ans[0] OR (ans[0] + 1) = 11 is 9, because 9 OR (9 + 1) = 11.
 * For i = 1, the smallest ans[1] that satisfies ans[1] OR (ans[1] + 1) = 13 is 12, because 12 OR (12 + 1) = 13.
 * For i = 2, the smallest ans[2] that satisfies ans[2] OR (ans[2] + 1) = 31 is 15, because 15 OR (15 + 1) = 31.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 2 <= nums[i] <= 1000
 * nums[i] is a prime number.
 */
public class ConstructtheMinimumBitwiseArrayI {

    /**
     * Intuition
     * ans[i] OR (ans[i] + 1) == nums[i]
     * ans[i] and ans[i] + 1 are one odd and one even.
     * nums[i] is an odd.
     * <p>
     * <p>
     * Explanation
     * ..0111 || (..0111 + 1) = ..1111
     * The effect is that change the rightmost 0 to 1.
     * <p>
     * For each a in array A,
     * find the rightmost 0,
     * and set the next bit from 1 to 0.
     * <p>
     * a + 1 will filp the 1-suffix to 0-suffix,
     * and flip the rightmost 0 to 1.
     * a & -a is a trick to get the rightmost 1.
     * <p>
     * <p>
     * Complexity
     * Time O(n)
     * Space O(n) for result
     */
    public int[] minBitwiseArray(List<Integer> A) {

        int n = A.size(), res[] = new int[n];
        for (int i = 0; i < n; i++) {
            int a = A.get(i);
            if (A.get(i) % 2 == 0) {
                res[i] = -1;
            } else {
                res[i] = a - ((a + 1) & (-a - 1)) / 2;
            }
        }
        return res;
    }
}
