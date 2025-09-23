package codingquestions.leetcode;

/*
37. Sudoku Solver
Solved
Hard
Topics
premium lock icon
Companies
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:


 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.
*/
class SudokuSolver {
    public char[][] c = new char[9][9];
    public boolean canBePlaced(char cc, int row, int col){
        //check the same row(
        for(int i = 0; i < 9; i++){
            if(c[row][i] == cc) return false;
        }

        //same col
        for(int i = 0; i < 9; i++){
            if(c[i][col] == cc) return false;
        }

        //same square
        int startRow = ((int)(row / 3)) * 3, startCol = ((int)(col / 3) * 3);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(c[startRow + i][startCol + j] == cc) return false;
            }
        }
        return true;
    }

    public boolean solveHelper(int row, int col){
        if(col == 9){
            row++;
            col = 0;
        }
        if(row == 9) return true;

        if(c[row][col] != '.') return solveHelper(row, col + 1);

        for(char num = '1'; num <= '9'; num++){
            if(canBePlaced(num, row, col)){
                c[row][col] = num;
                if(solveHelper(row, col + 1)) return true;

                c[row][col] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++) c[i][j] = board[i][j];
        
        solveHelper(0, 0);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++) board[i][j] = c[i][j];
        }
    }
};
