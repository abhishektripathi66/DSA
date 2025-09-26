// Given an integer n. You need to recreate the pattern given below for any
// value of N. Let's say for N = 5, the pattern should look like as below:
// *****
// *****
// *****
// *****
// *****

class Solution {
      // Function to print pattern1
      public void pattern1(int n) {

            // Outer loop will run for rows.
            for (int i = 0; i < n; i++) {

                  // Inner loop will run for columns.
                  for (int j = 0; j < n; j++) {
                        System.out.print("*");
                  }
                  /*
                   * As soon as n stars are printed, move
                   * to the next row and give a line break.
                   */
                  System.out.println();
            }
      }

      public static void main(String[] args) {
            int N = 4;

            // Create an instance of the Solution class
            Solution sol = new Solution();

            sol.pattern1(N);
      }
}