// Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//     *
//    ***
//   *****
//  *******
// *********

class Solution {
      // Function to print pattern7
      public static void pattern7(int n) {

            // Outer loop which will loop for the rows.
            for (int i = 0; i < n; i++) {

                  // This loop will print the spaces
                  for (int j = 0; j < n - i - 1; j++) {
                        System.out.print(" ");
                  }

                  // Inner loop will print asterisks
                  for (int j = 0; j < 2 * i + 1; j++) {
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

            sol.pattern7(N);
      }
}
