/*
840. Magic Squares In Grid
Solved
Medium
Topics
premium lock icon
Companies
A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

Given a row x col grid of integers, how many 3 x 3 magic square subgrids are there?

Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.

 

Example 1:


Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
Output: 1
Explanation: 
The following subgrid is a 3 x 3 magic square:

while this one is not:

In total, there is only one magic square inside the given grid.
Example 2:

Input: grid = [[8]]
Output: 0
 

Constraints:

row == grid.length
col == grid[i].length
1 <= row, col <= 10
0 <= grid[i][j] <= 15
*/
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length - 2; i++){
            for(int j = 0; j < grid[0].length - 2; j++){
                // (i, j) -> (i + 2, j + 2)
                boolean flag = true;
                int[] cnt = new int[10];
                for(int ii = i; ii <= i + 2; ii++){
                    for(int jj = j; jj <= j + 2; jj++){
                        if(grid[ii][jj] > 9 || grid[ii][jj] < 1){
                            flag = false;
                            break;
                        }
                        cnt[grid[ii][jj]]++;
                    }
                    if(!flag)
                        break;
                }
                
                for(int k = 1; k <= 9; k++){
                    if(cnt[k] != 1){
                        flag = false;
                        break;
                    }
                }

                if(!flag)
                    continue;
                
                int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                for(int row = i; row <= i + 2; row++){
                    int tmp_sum = 0;
                    for(int col = j; col <= j + 2; col++)
                        tmp_sum += grid[row][col];
                    if(tmp_sum != sum){
                        flag = false;
                        break;
                    }
                }

                for(int col = j; col <= j + 2; col++){
                    int tmp_sum = 0;
                    for(int row = i; row <= i + 2; row++)
                        tmp_sum += grid[row][col];
                    if(tmp_sum != sum){
                        flag = false;
                        break;
                    }
                }

                if(grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != sum ||
                grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] != sum || !flag)
                    continue;
                
                res++;
            }
        }
        return res;
    }
}
