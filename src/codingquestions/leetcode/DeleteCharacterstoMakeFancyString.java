package codingquestions.leetcode;

/**
 * 1957. Delete Characters to Make Fancy String
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * A fancy string is a string where no three consecutive characters are equal.
 * <p>
 * Given a string s, delete the minimum possible number of characters from s to make it fancy.
 * <p>
 * Return the final string after the deletion. It can be shown that the answer will always be unique.
 **/
public class DeleteCharacterstoMakeFancyString {
    public String makeFancyString(String s) {

        if (s == null || s.length() < 3) return s;
        int count = 1;
        StringBuffer sb = new StringBuffer();
        char lastchar = s.charAt(0);
        sb.append(lastchar);
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == lastchar) {
                if (count < 2) {
                    sb.append(s.charAt(i));
                }
                count++;
            } else {
                count = 1;
                sb.append(s.charAt(i));
                lastchar = s.charAt(i);
            }
        }

        return sb.toString();
    }
}

// best soltion 
class DeleteCharacterstoMakeFancyString1 {
    public String makeFancyString(String s) {
        int sameCount = 0;
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        for (char cur : s.toCharArray()) {
            if (cur == prev) {
                sameCount++;
            } else {
                sameCount = 1;
            }
            if (sameCount < 3) sb.append(cur);
            prev = cur;
        }
        return sb.toString();
    }
}
