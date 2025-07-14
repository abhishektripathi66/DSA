package codingquestions.leetcode;

/*
2131. Longest Palindrome by Concatenating Two Letter Words
Solved
Medium
Topics
Companies
Hint
You are given an array of strings words. Each element of words consists of two lowercase English letters.

Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.

Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.

A palindrome is a string that reads the same forward and backward.

 

Example 1:

Input: words = ["lc","cl","gg"]
Output: 6
Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
Note that "clgglc" is another longest palindrome that can be created.
Example 2:

Input: words = ["ab","ty","yt","lc","cl","ab"]
Output: 8
Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
Note that "lcyttycl" is another longest palindrome that can be created.
Example 3:

Input: words = ["cc","ll","xx"]
Output: 2
Explanation: One longest palindrome is "cc", of length 2.
Note that "ll" is another longest palindrome that can be created, and so is "xx".
 

Constraints:

1 <= words.length <= 105
words[i].length == 2
words[i] consists of lowercase English letters.
*/

public class LongestPalindromeByConcatenatingTwoLetterWords {
    int hash(String s) {
        return (s.charAt(0) - 'a') * 26 + (s.charAt(1) - 'a');
    }

    int reverseHash(String s) {
        return (s.charAt(1) - 'a') * 26 + (s.charAt(0) - 'a');
    }

    public int longestPalindrome(String[] words) {
        int[] cnt = new int[900];

        for (String i : words) {
            cnt[hash(i)]++;
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            //ii
            if (cnt[i * 26 + i] > 0) {
                res += (cnt[i * 26 + i] / 2);
                cnt[i * 26 + i] %= 2;
            }

            //ij (for j > i)
            for (int j = i + 1; j < 26; j++) {
                //ij, then ji
                res += Math.min(cnt[i * 26 + j], cnt[j * 26 + i]);
            }
        }

        res *= 4;
        for (int i = 0; i < 26; i++) {
            if (cnt[i * 26 + i] > 0) {
                res += 2;
                break;
            }
        }
        return res;
    }
}
