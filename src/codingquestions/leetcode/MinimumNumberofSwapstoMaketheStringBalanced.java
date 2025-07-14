package codingquestions.leetcode;

import java.util.Stack;

/**
 * 1963. Minimum Number of Swaps to Make the String Balanced
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
 * <p>
 * A string is called balanced if and only if:
 * <p>
 * It is the empty string, or
 * It can be written as AB, where both A and B are balanced strings, or
 * It can be written as [C], where C is a balanced string.
 * You may swap the brackets at any two indices any number of times.
 * <p>
 * Return the minimum number of swaps to make s balanced.
 **/
// Best solution
public class MinimumNumberofSwapstoMaketheStringBalanced {
    public int minSwaps(String s) {
        if (s.length() == 0) return 0;

        int swaps = 0;
        int open = 0;

        for (byte c : s.getBytes()) {
            open += '\\' - c;
            if (open < 0) {
                swaps++;
                open += 2;
            }
        }

        return swaps;
    }
}

// math soltuion
// Approach - 02 [ Math - derived from above ]
class MinimumNumberofSwapstoMaketheStringBalanced1 {
    public int minSwaps(String s) {
        int boys = 0;

        for (int i = 0; i < s.length(); i++) {
            if (boys > 0 && s.charAt(i) == ']') {
                boys--;
            } else {
                if (s.charAt(i) == '[') {
                    boys++;
                }

            }
        }


        return (int) Math.ceil((double) boys / 2);
    }
}

//stack solution
// Approach - 01 [ Stack ]
class MinimumNumberofSwapstoMaketheStringBalanced2 {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        for (char val : s.toCharArray()) { // for(int i=0; i<s.length(); i++)
            if (stack.isEmpty()) {
                stack.push(val); // val = s.charAt(i)
            } else if (stack.peek() == '[' && val == ']') {
                stack.pop();
            } else {
                stack.push(val); // val = s.charAt(i)
            }
        }

        // when you have single pair
        if (stack.size() == 2) {
            return 1;
        }

        // stack does have both girl and boy count
        // half of them would be the total swap amount
        int single = stack.size() / 2;

        // a. Math.ceil is used to handle odd case
        // b. for two-pair we need to do one swap
        //    so, total swap = single / 2
        return (int) Math.ceil((double) single / 2);
    }
}
