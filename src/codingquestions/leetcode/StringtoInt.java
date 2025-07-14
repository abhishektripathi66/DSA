package codingquestions.leetcode.ds;

public class StringtoInt {

    public static void main(String[] args) {

    }

    public int myAtoi1(String str) {
        int sign = 1, i = 0, r = 0;
        str = str.trim();
        if (str.isEmpty()) return 0;
        else if (str.charAt(i) == '-') {
            i++;
            sign = -1;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int d = str.charAt(i) - '0';
            if (r > (Integer.MAX_VALUE - d) / 10) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            r = r * 10 + d;
            i++;
        }
        return r * sign;
    }

    public int myAtoi(String s) {
        int ans = 0, idx = 0, n = s.length();

        while (idx < n && s.charAt(idx) == ' ') {
            idx++;
        }
        if (idx == n) return 0;

        boolean sign = true;
        if (s.charAt(idx) == '-') {
            idx++;
            sign = false;
        } else if (s.charAt(idx) == '+') {
            idx++;
        }
        while (idx < n && s.charAt(idx) == '0') {
            idx++;
        }
        for (; idx < n; idx++) {
            char c = s.charAt(idx);
            if (!Character.isDigit(c)) {
                break;
            }
            try {
                ans = Math.addExact(Math.multiplyExact(ans, 10), (c - '0'));
            } catch (Exception e) {
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return sign ? ans : -ans;
    }
}
