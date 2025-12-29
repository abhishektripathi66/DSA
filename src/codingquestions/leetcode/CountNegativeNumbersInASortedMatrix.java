/*
1351. Count Negative Numbers in a Sorted Matrix
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
 

Follow up: Could you find an O(n + m) solution?
*/
class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0;
        for(int[] i : grid)
            for(int j : i)
                res += (j < 0 ? 1 : 0);
        return res;
    }
}
