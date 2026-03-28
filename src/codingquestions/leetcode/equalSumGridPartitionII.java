package codingquestions.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Link :- https://leetcode.com/problems/equal-sum-grid-partition-ii/description/
 3548. Equal Sum Grid Partition II
 Hard

 Question :- You are given an m x n matrix grid of positive integers. Your task is to determine if it is possible to make either one horizontal or one vertical cut on the grid such that:

Each of the two resulting sections formed by the cut is non-empty.
The sum of elements in both sections is equal, or can be made equal by discounting at most one single cell in total (from either section).
If a cell is discounted, the rest of the section must remain connected.
Return true if such a partition exists; otherwise, return false.

Example 1:

Input: grid = [[1,4],[2,3]]

Output: true

Explanation:

A horizontal cut after the first row gives sums 1 + 4 = 5 and 2 + 3 = 5, which are equal. Thus, the answer is true.

Note: A section is connected if every cell in it can be reached from any other cell by moving up, down, left, or right through other cells in the section.

Example 2:

Input: grid = [[1,2,4],[2,3,5]]

Output: false

Explanation:

A horizontal cut after the first row gives 1 + 2 + 4 = 7 and 2 + 3 + 5 = 10.
By discounting 3 from the bottom section (10 - 3 = 7), both sections have equal sums, but they do not remain connected as it splits the bottom section into two parts ([2] and [5]). Thus, the answer is false.

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
public class equalSumGridPartitionII {
    boolean partition(int[][] grid) {
        Set<Long> set = new HashSet<>();
        int rows = grid.length;
        int cols = grid[0].length;
        long totalSum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                totalSum += grid[i][j];
            }
        }
        long sum = 0;
        for (int i = 0; i <= rows - 2; i++) {
            for (int j = 0; j < cols; j++) {
                set.add((long)grid[i][j]);
                sum += grid[i][j];
            }
            long bottom = totalSum - sum;
            long diff = sum - bottom;
            if (diff == 0) return true;
            if (diff == grid[0][0]) return true;
            if (diff == grid[0][cols - 1]) return true;
            if (diff == grid[i][0]) return true;
            if (i > 0 && cols > 1 && set.contains(diff)) return true;
        }
        return false;
    }
    public boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (partition(grid))
            return true;
        int[][] temp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp[i][j] = grid[rows - i - 1][j];
            }
        }
        if (partition(temp)) return true;
        temp = new int[cols][rows];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                temp[j][i] = grid[i][j];
            }
        }
        if (partition(temp)) return true;
        int[][] temp2 = new int[cols][rows];
        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
                temp2[i][j] = temp[cols - i - 1][j]; 
            }
        }
        return partition(temp2);
    }
}
