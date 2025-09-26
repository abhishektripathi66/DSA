/*
166. Fraction to Recurring Decimal
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

 

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 4, denominator = 333
Output: "0.(012)"
 

Constraints:

-231 <= numerator, denominator <= 231 - 1
denominator != 0
*/
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) 
            return "0";
        
        StringBuilder res = new StringBuilder();
        if((numerator < 0) ^ (denominator < 0))
            res.append('-');
        
        long num = Math.abs(Long.valueOf(numerator));
        long den = Math.abs(Long.valueOf(denominator));

        res.append(num / den);
        long rem = num % den;
        if(rem == 0)
            return res.toString();
        
        res.append('.');

        Map<Long, Integer> mp = new HashMap<>();
        while(rem != 0){
            if(mp.containsKey(rem)){
                res.insert(mp.get(rem), "(");
                res.append(')');
                break;
            }

            mp.put(rem, res.length());
            rem *= 10;
            res.append(rem / den);
            rem %= den;
        }
        return res.toString();
    }
}
