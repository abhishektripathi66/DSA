package codingquestions.recursion;

public class Pallindrome {

    public static void main(String[] args) {
        String str = "abbcbba";
        System.out.println(isPallindrome(str, 0, str.length() - 1));

    }

    public static boolean isPallindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        return (str.charAt(start) == str.charAt(end)) && isPallindrome(str, start + 1, end - 1);
    }

}
