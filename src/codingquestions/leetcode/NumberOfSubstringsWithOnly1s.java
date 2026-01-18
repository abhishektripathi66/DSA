/*
1513. Number of Substrings With Only 1s
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: s = "0110111"
Output: 9
Explanation: There are 9 substring in total with only 1's characters.
"1" -> 5 times.
"11" -> 3 times.
"111" -> 1 time.
Example 2:

Input: s = "101"
Output: 2
Explanation: Substring "1" is shown 2 times in s.
Example 3:

Input: s = "111111"
Output: 21
Explanation: Each substring contains only 1's characters.
 

Constraints:

1 <= s.length <= 105
s[i] is either '0' or '1'.
*/
class Solution {
    public int numSub(String s) {
        int res = 0;
        int MOD = 1000000007;
        long cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                cnt++;
                continue;
            }
            
            res += (cnt * (cnt + 1) / 2) % MOD;
            cnt = 0;
        }

        res += (cnt * (cnt + 1) / 2) % MOD;
        return res;
    }
}
