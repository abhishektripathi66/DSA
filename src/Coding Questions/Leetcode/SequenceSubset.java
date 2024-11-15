/**

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false

**/

class SequenceSubset {
    public boolean isSubsequence(String s, String t) {
        int sp = 0;
        int tp = 0;
        char[] sb = s.toCharArray();
        char[] tb = t.toCharArray();
        // using two pointer
        while (sp < sb.length && tp < tb.length) {

            // if it has the same character in both then increment s pointer along with t pointer else increment only t pointer
            if (sb[sp] == tb[tp]) {
                sp++;
            }
            tp++;
        }

        return sp == s.length();         
    }
}
