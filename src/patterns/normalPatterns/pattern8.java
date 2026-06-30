
    // Given an integer n. You need to recreate the pattern given below for any
// value of N. Let's say for N = 5, the pattern should look like as below:
// *****
// *   *
// *   *
// *   *
// *****

class Solution {
      // Function to print pattern8
      public static void pattern8(int n) {

            // Outer loop will run for rows.
            for (int i = 0; i < n; i++) {

                  // Inner loop will run for columns.
                  for (int j = 0; j < n; j++) {
                        // Print star for the first and last rows, and first and last columns
                        if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                              System.out.print("*");
                        } else {
                              System.out.print(" ");
                        }
                  }
                  System.out.println();
            }
      }

      public static void main(String[] args) {
            int N = 4;
            pattern8(N);
      }
}

