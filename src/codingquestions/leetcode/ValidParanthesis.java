package codingquestions.leetcode.ds;

/**
 * 921. Minimum Add to Make Parentheses Valid
 * Solved
 * Medium
 * Topics
 * Companies
 * A parentheses string is valid if and only if:
 * <p>
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 * <p>
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 **/
public class ValidParanthesis {
    public int minAddToMakeValid(String s) {
        int forward = 0;
        int mismatch = 0;
        char[] b = s.toCharArray();
        for (char a : b) {
            if (a == '(') forward++;
            else {
                if (forward > 0) forward--;
                else mismatch++;
            }
        }

        return mismatch + forward;
    }
}
