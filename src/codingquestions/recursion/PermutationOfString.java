package codingquestions.recursion;

public class PermutationOfString {

    public static void main(String[] args) {
        permute("abc", "");
        permute("abc", 0);
    }

    //time complexity: O(n! * n)
    //space complexity: O(n)
    public static void permute(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            permute(newStr, ans + ch);
        }
    }

    //time complexity: O(n! * n)
    //space complexity: O(n)
    public static void permute(String str, int j) {
        if (j == str.length() - 1) {
            System.out.println(str);
            return;
        }

        for (int i = j; i < str.length(); i++) {
            // swap
            StringBuilder sb = new StringBuilder(str);
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);

            permute(sb.toString(), j + 1);
            // backtrack
            temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            str = sb.toString();
        }
    }

}
