package codingquestions.leetcode;

/*
20. Valid Parentheses
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

import java.util.Stack;

public class ValidParentheses {
    private int hashOf(char c) {
        if (c == '(')
            return 0;

        if (c == ')')
            return 1;

        if (c == '{')
            return 2;

        if (c == '}')
            return 3;

        if (c == '[')
            return 4;

        return 5;
    }

    public boolean isValid(String s) {
        Stack<Integer> openPosition = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int c = hashOf(s.charAt(i));
            if (c % 2 == 0) {
                openPosition.push(i);
            } else {
                if (openPosition.isEmpty() || hashOf(s.charAt(openPosition.pop())) != c - 1) {
                    return false;
                }
            }
        }
        if (openPosition.size() > 0)
            return false;

        return true;
    }
}
