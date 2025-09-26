// Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
// 1
// 22
// 333
// 4444
// 55555

class Solution {
      // Function to print pattern4
      public static void pattern4(int n) {

            // Outer loop which will loop for the rows.
            for (int i = 1; i <= n; i++) {

                  // Inner loop which loops for the columns.
                  for (int j = 1; j <= i; j++) {
                        System.out.print(i);
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

            sol.pattern4(N);
      }
}
