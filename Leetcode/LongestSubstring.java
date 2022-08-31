package Leetcode;

import java.util.HashSet;

/*
 * Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * 
 */

public class LongestSubstring {
    
    public static void main(String[] args) {
        var lss = new LongestSubstring();
        System.out.println(lss.lengthOfLongestSubstring(s));
    }

    
    
    public int lengthOfLongestSubstring(String s) {
        int startIndex= 0;
        int lastIndex= 0;
        int n= s.length();
        HashSet<Character> hs= new HashSet<>();
        int maxSize= 0;
        
        while(startIndex != n && lastIndex != n){
            if( !hs.contains(s.charAt(lastIndex)) ){
                hs.add( s.charAt(lastIndex) );
                lastIndex++;
            }
            
            else{
                hs.remove( s.charAt(startIndex) );
                startIndex++;
            }
            
            if(hs.size() > maxSize){
                maxSize= hs.size();
            }
        }
        
        return maxSize;
    }
}
