package codingquestions.leetcode;

import java.util.Arrays;


/**
 * 
 * 242. Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

*/

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char str1 [] = s.toCharArray();
        char str2 [] = t.toCharArray();
        if(s.length() != t.length())
            return false;
        Arrays.sort(str1);
        Arrays.sort(str2);
        for(int i=0; i< str1.length; i++){
            if(str1[i] != str2[i])
                return false;
        }
        return true;
    }
}
