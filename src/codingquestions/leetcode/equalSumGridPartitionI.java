package codingquestions.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Link :- https://leetcode.com/problems/equal-sum-grid-partition-i/
 3548. Equal Sum Grid Partition I
 Hard

 Question :- You are given an m x n matrix grid of positive integers. Your task is to determine if it is possible to make either one horizontal or one vertical cut on the grid such that:

Each of the two resulting sections formed by the cut is non-empty.
The sum of the elements in both sections is equal.
Return true if such a partition exists; otherwise return false.
Example 1:

Input: grid = [[1,4],[2,3]]

Output: true

Explanation:

A horizontal cut between row 0 and row 1 results in two non-empty sections, each with a sum of 5. Thus, the answer is true.
Example 2:

Input: grid = [[1,3],[2,4]]

Output: false

Explanation:

No horizontal or vertical cut results in two non-empty sections with equal sums. Thus, the answer is false.
Constraints:

1 <= m == grid.length <= 10^5
1 <= n == grid[i].length <= 10^ 5
2 <= m * n <= 10^5
1 <= grid[i][j] <= 10^5

Hint 1
In a grid (or any subgrid), when can a section be disconnected? Can disconnected components occur if the section spans more than one row and more than one column?

Hint 2
Handle single rows or single columns separately. For all other partitions, maintain the sums and value frequencies of each section to check whether removing at most one element from one section can make the two sums equal.
 */
public class equalSumGridPartitionI {
    public boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        long[] rowSum = new long[cols];
        long[] colSum = new long[rows];
        for (int i = 0; i < rows; i++){
            long sum = 0;
            for (int j = 0; j < cols; j++){
                sum += grid[i][j];
            }
            colSum[i] = sum;
        }
        for (int i = 0; i < cols; i++){
            long sum = 0;
            for (int j = 0; j < rows; j++){
                sum += grid[j][i];
            }
            rowSum[i] = sum;
        }
        long sum = 0;
        for (long i: rowSum){
            sum += i;
        }
        long t = 0;
        for (long i: rowSum){
            t += i;
            if (t == (sum - t)) return true;
        }
        t = 0;
        for (long i: colSum){
            t += i;
            if (t == (sum - t)) return true;
        }
        return false;
    }
}
