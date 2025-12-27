class Solution {
    public int myAtoi(String s) {
        int pos = 0;
        // step 1
        while(pos < s.length() && s.charAt(pos) == ' ')
            pos++;
        
        if(pos == s.length())
            return 0;
        
        // step 2
        int sign = 1; // 1 for +, 0 for -
        if(s.charAt(pos) == '+' || s.charAt(pos) == '-'){
            if(s.charAt(pos) == '-')
                sign = 0;
            pos++;
        }

        if(pos == s.length())
            return 0;
        
        // step 3
        long res = 0;
        while(pos < s.length() && s.charAt(pos) >= '0' && s.charAt(pos) <= '9'){
            res = res * 10 + (s.charAt(pos) - '0');
            System.out.println(pos + " " + res);
            pos++;
            if(res > (long)Integer.MAX_VALUE + 2 || res < (long)Integer.MIN_VALUE - 2)
                break;
            }
        
        if(sign == 0)
            res = 0 - res;
        
        // step 4
        int ans;
        if(res > Integer.MAX_VALUE)
            ans = Integer.MAX_VALUE;
        else if(res < Integer.MIN_VALUE)
            ans = Integer.MIN_VALUE;
        else ans = (int)res;

        return ans;
    }
}
// package codingquestions.leetcode;

// public class StringtoInt {

//     public static void main(String[] args) {

//     }

//     public int myAtoi1(String str) {
//         int sign = 1, i = 0, r = 0;
//         str = str.trim();
//         if (str.isEmpty()) return 0;
//         else if (str.charAt(i) == '-') {
//             i++;
//             sign = -1;
//         } else if (str.charAt(i) == '+') {
//             i++;
//         }
//         while (i < str.length() && Character.isDigit(str.charAt(i))) {
//             int d = str.charAt(i) - '0';
//             if (r > (Integer.MAX_VALUE - d) / 10) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//             r = r * 10 + d;
//             i++;
//         }
//         return r * sign;
//     }

//     public int myAtoi(String s) {
//         int ans = 0, idx = 0, n = s.length();

//         while (idx < n && s.charAt(idx) == ' ') {
//             idx++;
//         }
//         if (idx == n) return 0;

//         boolean sign = true;
//         if (s.charAt(idx) == '-') {
//             idx++;
//             sign = false;
//         } else if (s.charAt(idx) == '+') {
//             idx++;
//         }
//         while (idx < n && s.charAt(idx) == '0') {
//             idx++;
//         }
//         for (; idx < n; idx++) {
//             char c = s.charAt(idx);
//             if (!Character.isDigit(c)) {
//                 break;
//             }
//             try {
//                 ans = Math.addExact(Math.multiplyExact(ans, 10), (c - '0'));
//             } catch (Exception e) {
//                 return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//             }
//         }
//         return sign ? ans : -ans;
//     }
// }
