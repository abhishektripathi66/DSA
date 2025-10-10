// Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

// *
// **
// ***
// ****
// *****
class Solution {
      // Function to print pattern2
      public static void pattern2(int n) {

            // Outer loop which will loop for the rows.
            for (int i = 0; i < n; i++) {

                  // Inner loop which loops for the columns.
                  for (int j = 0; j <= i; j++) {
                        System.out.print("*");
                  }
                  /*
                   * As soon as stars for each iteration are printed,
                   * move to the next row and give a line break
                   */
                  System.out.println();
            }
      }

      public static void main(String[] args) {
            int N = 5;

            // Create an instance of Solution class
            Solution sol = new Solution();

            sol.pattern2(N);
      }
}
