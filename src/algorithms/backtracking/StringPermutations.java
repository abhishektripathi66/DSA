package algorithms.backtracking;
/*
 * Problem: Print all unique permutations of a given string.
 *
 * Given a string (which may have duplicate characters), print all possible unique arrangements
 * of its characters using recursion and backtracking.
 *
 * Time Complexity: O(n * n!) in the worst case (with n being the string length)
 * Space Complexity: O(n) for recursion stack
 *
 * Example:
 *   Input: "AAB"
 *   Output:
 *     AAB
 *     ABA
 *     BAA
 */

public class StringPermutations {
    public static void main(String[] args) {
        String str = "AAB";
        //String str = "ABC"; 
        int n = str.length();
        System.out.println("All unique permutations of \"" + str + "\" are:");
        new StringPermutations().permute(str, 0, n - 1);
    }

    void permute(String str, int l, int r) {
        if (l == r) {
            System.out.println(str); //one permutation is formed
            return;
        }

        for (int i = l; i <= r; i++) {
            // check if swapping str[l] and str[i] will result in a unique permutation
            if (isSafe(str, l, i, r)) {
                // swap characters at position l and i
                str = swap(str, l, i);

                // recurse for the next position
                permute(str, l + 1, r);

                // backtrack (restore original string before next iteration)
                str = swap(str, l, i);
            }
        }
    }

    boolean isSafe(String str, int l, int i, int r) {
        for (int j = l; j < i; j++) {
            if (str.charAt(j) == str.charAt(i)) {
                return false; // duplicate character found before index i
            }
        }
        return true;
    }

    String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
