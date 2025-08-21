/*
1323. Maximum 69 Number
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

 

Example 1:

Input: num = 9669
Output: 9969
Explanation: 
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.
Example 2:

Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.
Example 3:

Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.
 

Constraints:

1 <= num <= 104
num consists of only 6 and 9 digits.
*/
class Solution {
    public int maximum69Number (int num) {
        String s_num = Integer.toString(num);
        for(int i = 0; i < s_num.length(); i++){
            if(s_num.charAt(i) == '6'){
                s_num = s_num.substring(0, i) + '9' + s_num.substring(i + 1);
                break;
            }
        }
        return Integer.parseInt(s_num);
    }
}
