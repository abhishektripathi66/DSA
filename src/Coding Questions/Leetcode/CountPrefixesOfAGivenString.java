/*
2255. Count Prefixes of a Given String
Solved
Easy
Topics
Companies
Hint
You are given a string array words and a string s, where words[i] and s comprise only of lowercase English letters.

Return the number of strings in words that are a prefix of s.

A prefix of a string is a substring that occurs at the beginning of the string. A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: words = ["a","b","c","ab","bc","abc"], s = "abc"
Output: 3
Explanation:
The strings in words which are a prefix of s = "abc" are:
"a", "ab", and "abc".
Thus the number of strings in words which are a prefix of s is 3.
Example 2:

Input: words = ["a","a"], s = "aa"
Output: 2
Explanation:
Both of the strings are a prefix of s. 
Note that the same string can occur multiple times in words, and it should be counted each time.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length, s.length <= 10
words[i] and s consist of lowercase English letters only.
*/
class CountPrefixesOfAGivenString {
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for(String str : words){
            if(str.length() > s.length())
                continue;
            if(s.substring(0, str.length()).equals(str))
                res++;
        }
        return res;
    }
}
