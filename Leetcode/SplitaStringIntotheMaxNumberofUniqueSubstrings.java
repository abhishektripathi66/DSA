/**
1593. Split a String Into the Max Number of Unique Substrings
Solved
Medium
Topics
Companies
Hint
Given a string s, return the maximum number of unique substrings that the given string can be split into.

You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.

A substring is a contiguous sequence of characters within a string.
  **/
class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int start, Set<String> uniqueSubstrings) {
        if (start == s.length()) {
            return uniqueSubstrings.size();  
        }

        int maxUnique = 0;
        for (int i = start + 1; i <= s.length(); i++) {
            String currentSubstring = s.substring(start, i);
            if (!uniqueSubstrings.contains(currentSubstring)) {  
                uniqueSubstrings.add(currentSubstring);  
                maxUnique = Math.max(maxUnique, backtrack(s, i, uniqueSubstrings));  
                uniqueSubstrings.remove(currentSubstring);  
            }
        }

        return maxUnique;
    }
}
