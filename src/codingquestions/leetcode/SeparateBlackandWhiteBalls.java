package codingquestions.leetcode.ds;

/**
 * 2938. Separate Black and White Balls
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * There are n balls on a table, each ball has a color black or white.
 * <p>
 * You are given a 0-indexed binary string s of length n, where 1 and 0 represent black and white balls, respectively.
 * <p>
 * In each step, you can choose two adjacent balls and swap them.
 * <p>
 * Return the minimum number of steps to group all the black balls to the right and all the white balls to the left.
 **/

public class SeparateBlackandWhiteBalls {
    public long minimumSteps(String s) {
        long swap = 0;
        int black = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                swap += (long) black;
            else
                black++;
        }
        return swap;
    }
}
