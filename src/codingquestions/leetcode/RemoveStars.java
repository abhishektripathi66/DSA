package codingquestions.leetcode;

import java.util.Stack;

/**
 * 2390. Removing Stars From a String
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a string s, which contains stars *.
 * <p>
 * In one operation, you can:
 * <p>
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 * <p>
 * Note:
 * <p>
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 **/

public class RemoveStars {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '*') {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();


    }

    public String removestarsBest(String s) {
        int len = s.length();
        byte[] res = new byte[len];
        int countStars = 0;
        for (int i = 0; i < len; i++) {
            if (res[i] == '*') countStars++;
            else res[i - countStars * 2] = res[i];
        }
        return new String(res, 0, len - countStars * 2);
    }

}
