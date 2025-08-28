/*
1249. Minimum Remove to Make Valid Parentheses
Medium
Topics
premium lock icon
Companies
Hint
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 

Constraints:

1 <= s.length <= 105
s[i] is either '(' , ')', or lowercase English letter.
*/
class Solution {
    public String minRemoveToMakeValid(String s) {
        int cnt = 0;
        String r1 = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                cnt++;
            else if(s.charAt(i) == ')'){
                if(cnt > 0)
                    cnt--;
                else
                    continue;
            }
            r1 += s.charAt(i);
        }

        String r2 = "";
        cnt = 0;
        for(int i = r1.length() - 1; i >= 0; i--){
            if(r1.charAt(i) == ')')
                cnt++;
            else if(r1.charAt(i) == '('){
                if(cnt > 0)
                    cnt--;
                else
                    continue;
            }
            r2 += r1.charAt(i);
        }
        String res = "";
        for(int i = r2.length() - 1; i >= 0; i--)
            res += r2.charAt(i);

        return res;
    }
}
