package codingquestions.leetcode;

/**
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

**/


public class SudokuSolver {
    private char[][] board;
    public void solveSudoku(char[][] board) {
        this.board=board;
        helper(0,0);
    }
    public boolean helper(int row,int col){
        //if I'm at last column then move to next row
        if(col==9){
            row+=1;
            col=0;
        }
        // if my row is last then 
        if(row==9) return true;

        //if we have a value at the block then we move to the next block
        if(board[row][col]!='.') return helper(row,col+1);

        // here we will check if the point where we are adding the value is it valid or not from 1 to 9, if its not valid we move to next number, if its valid we add that number and go to the next column; if the helper return false then we revert back to '.';
        for(char i='1';i<='9';i++){
            if(!isvalid(row,col,i)) continue;
            board[row][col]=i;
            if(helper(row,col+1)==true) return true;
            board[row][col]='.';
        }
        return false;
    }

    public boolean isvalid(int row, int col, char cur){
        //check is element exists in the current row or the current column
        for(int i=0;i<9;i++){
            if(board[row][i]==cur) return false;
            if(board[i][col]==cur) return false;
        }

        //create the row border and column border to find the start and end point of the column
        int[] rowborder = findSE(row);
        int[] colborder = findSE(col);

        //check the values in the current box
        for(int i=rowborder[0];i<=rowborder[1];i++)  {
            for(int j=colborder[0];j<=colborder[1];j++){
                if(board[i][j]==cur){
                    return false;
                }
            }
        }
        return true;

    }

    // to find the start and the end border
    private int[] findSE(int coor){
        int[] res = new int[2];
        if(coor<3){
            res[1]=2;
        }
        else if(coor<6){
            res[0]=3;
            res[1]=5;
        }
        else{
            res[0]=6;
            res[1]=8;
        }
        return res;
    }
}
