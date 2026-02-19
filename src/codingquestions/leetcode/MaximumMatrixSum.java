/*
1975. Maximum Matrix Sum
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an n x n integer matrix. You can do the following operation any number of times:

Choose any two adjacent elements of matrix and multiply each of them by -1.
Two elements are considered adjacent if and only if they share a border.

Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.

 

Example 1:


Input: matrix = [[1,-1],[-1,1]]
Output: 4
Explanation: We can follow the following steps to reach sum equals 4:
- Multiply the 2 elements in the first row by -1.
- Multiply the 2 elements in the first column by -1.
Example 2:


Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
Output: 16
Explanation: We can follow the following step to reach sum equals 16:
- Multiply the 2 last elements in the second row by -1.
 

Constraints:

n == matrix.length == matrix[i].length
2 <= n <= 250
-105 <= matrix[i][j] <= 105
*/
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long res = 0;
        int is_cnt_odd = 0, minAbs = (int)1e9;
        for(int[] i : matrix){
            for(int j : i){
                if(j < 0)
                    is_cnt_odd = 1 - is_cnt_odd;
                
                minAbs = Math.min(minAbs, Math.abs(j));
                res += Math.abs(j);
            }
        }

        if(is_cnt_odd == 1)
            res -= (minAbs * 2);
        
        return res;
    }
}
