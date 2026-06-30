//  Create the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//     *********
//      *******
//       *****
//        ***
//         *


class Solution {
    // Function to print Pattern 8
    public void pattern8(int N) {
        // Outer loop for rows
        for (int i = 0; i < N; i++) {

            // Print leading spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 0; j < 2 * N - (2 * i + 1); j++) {
                System.out.print("*");
            }

            // Print trailing spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // Move to next row
            System.out.println();
        }
    }
}

public class pattern8 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int N = 5;
        sol.pattern8(N);
    }
}
