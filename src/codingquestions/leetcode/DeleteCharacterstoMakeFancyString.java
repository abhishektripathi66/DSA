package codingquestions.leetcode;

/*
1957. Delete Characters to Make Fancy String
Solved
Easy
Topics
premium lock icon
Companies
Hint
A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.

 

Example 1:

Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".
Example 2:

Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".
Example 3:

Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".
 

Constraints:

1 <= s.length <= 105
s consists only of lowercase English letters.
*/
public class DeleteCharacterstoMakeFancyString {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        char cur = s.charAt(0);
        int cnt = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == cur){
                cnt++;
            }
            else{
                cur = s.charAt(i);
                cnt = 1;
            }
            if(cnt < 3)
                res.append(s.charAt(i));
        }

        return res.toString();
    }

 public String makeFancyStringeff(String s) {
        char[] c = s.toCharArray();
        int k=1;
        int count=1;
        for(int i=1;i<s.length();i++){
            if(c[i]==c[i-1]){
                if(count<2){
                    c[k++]=c[i];
                }
                count++;
            }
            else{
                count=1;
                c[k++]=c[i];
            }
        }
        return new String(c,0,k);
    }
}
