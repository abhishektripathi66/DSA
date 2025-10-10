// Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
// 1
// 12
// 123
// 1234
// 12345

class Solution {
      // Function to print pattern3
      public static void pattern3(int n) {

            // Outer loop which will loop for the rows.
            for (int i = 1; i <= n; i++) {

                  // Inner loop which loops for the columns.
                  for (int j = 1; j <= i; j++) {
                        System.out.print(j);
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

            sol.pattern3(N);
      }
}
