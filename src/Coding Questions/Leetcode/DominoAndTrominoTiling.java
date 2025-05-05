/*
790. Domino and Tromino Tiling
Solved
Medium
Topics
Companies
You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.


Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

 

Example 1:


Input: n = 3
Output: 5
Explanation: The five different ways are show above.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 1000
*/
class Solution {
    public int numTilings(int n) {
        int N = 1005;
        long[] dp1 = new long[N]; //full to i-th column
        long[] dp2 = new long[N]; //full to i-th column, (i + 1)-th column has 1 cell filled

        dp1[0] = 0;
        dp1[1] = 1;
        dp1[2] = 2;

        dp2[0] = 0;
        dp2[1] = 1;
        dp2[2] = 2;

        int mod = 1000000007;

        for(int i = 3; i <= n; i++){
            dp1[i] = (dp1[i - 1] + dp1[i - 2] + 2 * dp2[i - 2]) % mod;
            dp2[i] = (dp1[i - 1] + dp2[i - 1]) % mod;
        }
        return (int)dp1[n];
    }
}
