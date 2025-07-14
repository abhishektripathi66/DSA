import java.util.Stack;

/**
 * 394. Decode String
 * Solved
 * Medium
 * Topics
 * Companies
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * <p>
 * The test cases are generated so that the length of the output will never exceed 105.
 **/

public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else {
                String ints = "1234567890";
                String numb = "";
                String a = "";
                while (!stack.isEmpty()) {
                    Character c = stack.pop();
                    if (c == '[') break;
                    a = c + a;
                }

                while (!stack.isEmpty()) {
                    Character c = stack.pop();
                    if (ints.indexOf(c) != -1) numb = c + numb;
                    else {
                        stack.push(c);
                        break;
                    }
                }

                int num = Integer.parseInt(numb);

                for (int j = 0; j < num; j++) {
                    for (int k = 0; k < a.length(); k++) {
                        stack.push(a.charAt(k));
                    }
                }
            }
        }

        String ret = "";
        while (!stack.isEmpty()) {
            ret = stack.pop() + ret;
        }

        return ret;
    }
}
