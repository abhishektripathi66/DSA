package codingquestions.leetcode.ds;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Daily Temperatures (LeetCode 739)
 *
 * Problem:
 * Given an array T where T[i] is the temperature on day i, return an array ans such that
 * ans[i] is the number of days you have to wait after day i to get a warmer temperature.
 * If there is no future day for which this is possible, keep ans[i] = 0.
 *
 * Pattern / Topics / Keywords:
 * arrays; monotonic stack; next-greater-element (NGE) variant; stack of indices; single pass
 *
 * Approach:
 * Maintain a decreasing (by temperature) stack of indices. For each i, while T[i] > T[stack.peek()],
 * pop j = stack.pop() and set ans[j] = i - j. Push i at the end. Elements left in the stack have 0.
 *
 * Complexity:
 * Time  : O(n) — each index is pushed and popped at most once
 * Space : O(n) — stack in the worst case
 *
 * Example I/O:
 * Input : [73,74,75,71,69,72,76,73]
 * Output: [1, 1, 4, 2, 1, 1, 0, 0]
 *
 * Edge Cases:
 * - empty input → []
 * - single element → [0]
 * - strictly increasing temps → distances increase accordingly
 * - strictly decreasing temps → all zeros
 *
 * Notes:
 * - A small timing harness in main prints elapsed milliseconds for sample runs (environment-dependent).
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && t[i] > t[st.peek()]) {
                int j = st.pop();
                ans[j] = i - j;
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures s = new DailyTemperatures();

        boolean ok = true;
        ok &= Arrays.equals(s.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}), new int[]{1,1,4,2,1,1,0,0});
        ok &= Arrays.equals(s.dailyTemperatures(new int[]{30,40,50,60}), new int[]{1,1,1,0});
        ok &= Arrays.equals(s.dailyTemperatures(new int[]{30,60,90}), new int[]{1,1,0});
        ok &= Arrays.equals(s.dailyTemperatures(new int[]{90,80,70,60}), new int[]{0,0,0,0});
        ok &= Arrays.equals(s.dailyTemperatures(new int[]{}), new int[]{});
        ok &= Arrays.equals(s.dailyTemperatures(new int[]{42}), new int[]{0});

        long start = System.nanoTime();
        s.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        long end = System.nanoTime();
        double ms = (end - start) / 1_000_000.0;

        System.out.println(ok ? "OK" : "FAIL");
        System.out.printf("Sample runtime: %.3f ms%n", ms);
    }
}
