/**
1657. Determine if Two Strings Are Close
Solved
Medium
Topics
Companies
Hint
Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

**/

class Solution {
    public boolean closeStrings(String word1, String word2) {
         int arr1[] = new int[26];
        int arr2[] = new int[26];

        for(var a : word1.toCharArray()){
            arr1[a-'a']++;
        }

        for(var a : word2.toCharArray()){
            arr2[a-'a']++;
        } 

        for(int i=0; i<26; i++){
            if((arr1[i]==0 && arr2[i]!=0) || (arr1[i]!=0 && arr2[i]==0)) return false;
            int x = arr1[i];
            int y = arr2[i];
            for(int j=i+1; j<26; j++){
                if(arr1[j]==y){
                    arr1[i] = y;
                    arr1[j] = x;
                    break;
                }
            }
        }

        for(int i=0; i<26; i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
}
