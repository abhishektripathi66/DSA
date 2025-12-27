/*
1930. Unique Length-3 Palindromic Subsequences
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

A palindrome is a string that reads the same forwards and backwards.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")
Example 2:

Input: s = "adc"
Output: 0
Explanation: There are no palindromic subsequences of length 3 in "adc".
Example 3:

Input: s = "bbcbaba"
Output: 4
Explanation: The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "bbcbaba")
- "bcb" (subsequence of "bbcbaba")
- "bab" (subsequence of "bbcbaba")
- "aba" (subsequence of "bbcbaba")
 

Constraints:

3 <= s.length <= 105
s consists of only lowercase English letters.
*/
class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] before = new int[26];
        int[] after = new int[26];
        int[][] res = new int[26][26]; // res[i][j] = whether there is "iji"
        for(int i = 0; i < s.length(); i++)
            after[s.charAt(i) - 'a']++;
        
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            after[c]--;
            for(int j = 0; j < 26; j++){
                if(Math.min(before[j], after[j]) > 0)
                    res[j][c] = 1;
            }
            
            before[c]++;
        }

        int ans = 0;
        for(int i = 0; i < 26; i++)
            for(int j = 0; j < 26; j++)
                ans += res[i][j];
        
        return ans;
    }
}
