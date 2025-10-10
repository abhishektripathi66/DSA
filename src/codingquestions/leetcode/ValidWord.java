/*
3136. Valid Word
Solved
Easy
Topics
premium lock icon
Companies
Hint
A word is considered valid if:

It contains a minimum of 3 characters.
It contains only digits (0-9), and English letters (uppercase and lowercase).
It includes at least one vowel.
It includes at least one consonant.
You are given a string word.

Return true if word is valid, otherwise, return false.

Notes:

'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
A consonant is an English letter that is not a vowel.
 

Example 1:

Input: word = "234Adas"

Output: true

Explanation:

This word satisfies the conditions.

Example 2:

Input: word = "b3"

Output: false

Explanation:

The length of this word is fewer than 3, and does not have a vowel.

Example 3:

Input: word = "a3$e"

Output: false

Explanation:

This word contains a '$' character and does not have a consonant.

 

Constraints:

1 <= word.length <= 20
word consists of English uppercase and lowercase letters, digits, '@', '#', and '$'.
*/
class Solution {
    private char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    private boolean isVowel(char c){
        for(char v : vowels){
            if(v == c)
                return true;
        }
        return false;
    }

    public boolean isValid(String word) {
        if(word.length() < 3) 
            return false;
        
        int cntvowel = 0, cntconsonant = 0;
        for(char c : word.toCharArray()){
            if(c >= '0' && c <= '9')
                continue;
            
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                if(isVowel(c))
                    cntvowel++;
                else
                    cntconsonant++;
            }
            else
                return false;
        }

        return (cntvowel > 0 && cntconsonant > 0);
    }
}
