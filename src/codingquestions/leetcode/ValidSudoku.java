/*
36. Valid Sudoku
Solved
Medium
Topics
premium lock icon
Companies
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        //row
        for(int row = 0; row < 9; row++){
            int[] cnt = new int[9];
            for(int col = 0; col < 9; col++){
                if(board[row][col] != '.')
                    cnt[board[row][col] - '0' - 1]++;
            }
            for(int i = 0; i < 9; i++){
                if(cnt[i] > 1)
                    return false;
            }
        }
        
        //col
        for(int col = 0; col < 9; col++){
            int[] cnt = new int[9];
            for(int row = 0; row < 9; row++){
                if(board[row][col] != '.')
                    cnt[board[row][col] - '0' - 1]++;
            }
            for(int i = 0; i < 9; i++){
                if(cnt[i] > 1)
                    return false;
            }
        }

        //square
        for(int row = 0; row < 9; row += 3){
            for(int col = 0; col < 9; col += 3){
                int[] cnt = new int[9];
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        if(board[row + i][col + j] != '.')
                            cnt[board[row + i][col + j] - '0' - 1]++;
                    }
                }
                for(int i = 0; i < 9; i++){
                    if(cnt[i] > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
