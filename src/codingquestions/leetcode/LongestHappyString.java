package codingquestions.leetcode;

/**
 * 1405. Longest Happy String
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * A string s is called happy if it satisfies the following conditions:
 * <p>
 * s only contains the letters 'a', 'b', and 'c'.
 * s does not contain any of "aaa", "bbb", or "ccc" as a substring.
 * s contains at most a occurrences of the letter 'a'.
 * s contains at most b occurrences of the letter 'b'.
 * s contains at most c occurrences of the letter 'c'.
 * Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 **/

public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        int contA = 0, contB = 0, contC = 0;
        int total = a + b + c;
        for (int i = 0; i < total; i++) {
            if ((a >= b && a >= c && contA != 2) || ((contB == 2 || contC == 2) && a > 0)) {
                sb.append("a");
                a--;
                contA++;
                contB = 0;
                contC = 0;
            } else if ((b >= a && b >= c && contB != 2) || ((contA == 2 || contC == 2) && b > 0)) {
                sb.append("b");
                b--;
                contB++;
                contA = 0;
                contC = 0;
            } else if ((c >= a && c >= b && contC != 2) || ((contA == 2 || contB == 2) && c > 0)) {
                sb.append("c");
                c--;
                contC++;
                contA = 0;
                contB = 0;
            }
        }
        return sb.toString();
    }
}
