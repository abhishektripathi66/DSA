package codingquestions.leetcode;

/*
3541. Find Most Frequent Vowel and Consonant
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given a string s consisting of lowercase English letters ('a' to 'z').

Your task is to:

Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
Find the consonant (all other letters excluding vowels) with the maximum frequency.
Return the sum of the two frequencies.

Note: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them. If there are no vowels or no consonants in the string, consider their frequency as 0.

The frequency of a letter x is the number of times it occurs in the string.
 

Example 1:

Input: s = "successes"

Output: 6

Explanation:

The vowels are: 'u' (frequency 1), 'e' (frequency 2). The maximum frequency is 2.
The consonants are: 's' (frequency 4), 'c' (frequency 2). The maximum frequency is 4.
The output is 2 + 4 = 6.
Example 2:

Input: s = "aeiaeia"

Output: 3

Explanation:

The vowels are: 'a' (frequency 3), 'e' ( frequency 2), 'i' (frequency 2). The maximum frequency is 3.
There are no consonants in s. Hence, maximum consonant frequency = 0.
The output is 3 + 0 = 3.
 

Constraints:

1 <= s.length <= 100
s consists of lowercase English letters only.
*/
class FindMostFrequentVowelAndConsonant {
    private static String vowels = "aeiou";

    private boolean isVowel(int x){
        for(int i = 0; i < 5; i++){
            if(vowels.charAt(i) - 'a' == x)
                return true;
        }
        return false;
    }

    public int maxFreqSum(String s) {
        char[] cnt = new char[26];
        for(int i = 0; i < s.length(); i++)
            cnt[s.charAt(i) - 'a']++;
        
        int res1 = 0, res2 = 0;
        for(int i = 0; i < 26; i++){
            if(isVowel(i))
                res1 = Math.max(res1, cnt[i]);
            else
                res2 = Math.max(res2, cnt[i]);
        }

        return res1 + res2;
    }
}
