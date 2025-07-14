package codingquestions.generalquestions;

public class PowerSetUsingBitWiseOperators {

    public static void main(String[] args) {
        powerset("abc", 3);
    }

    // time complexity: O(2^n)
    // space complexity: O(1)
    public static void powerset(String s, int n) {
        int powerSetSize = 1 << n; // 2^n
        for (int i = 0; i < powerSetSize; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) { // Check if jth bit is set
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }

}
