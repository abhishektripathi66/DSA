public class SudokuSolver {

    /**
     * Solves a given 9x9 Sudoku puzzle using backtracking.
     * The input board is a 2D character array where empty cells are denoted by '.'.
     * The method modifies the board in place to produce a valid solution.
     */
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    /**
     * Recursive backtracking solver:
     * - For each empty cell, try digits '1' to '9'.
     * - Place the digit if valid, and recursively solve the rest.
     * - If no digit fits, backtrack (undo the placement and try the next digit).
     */
    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // Skip cells that already have a number
                if (board[row][col] != '.') continue;

                // Try placing digits from '1' to '9'
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, row, col, num)) {
                        board[row][col] = num; // Tentatively place number

                        // Recursively try to solve the rest of the board
                        if (solve(board)) return true;

                        // Backtrack if this placement didn't lead to a solution
                        board[row][col] = '.';
                    }
                }

                // If no number fits in this cell, return false to backtrack
                return false;
            }
        }
        return true; // All cells are filled correctly
    }

    /**
     * Checks whether placing a digit in the given row, column is valid.
     * Ensures the number doesn't appear in the current row, column, or 3x3 sub-box.
     */
    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check row and column for duplicates
            if (board[row][i] == num || board[i][col] == num) return false;

            // Check 3x3 sub-box for duplicates
            int subRow = 3 * (row / 3) + i / 3;
            int subCol = 3 * (col / 3) + i % 3;
            if (board[subRow][subCol] == num) return false;
        }
        return true;
    }

    /**
     * Main method for testing the Sudoku solver.
     * Loads a board with empty cells, solves it, and prints the solution.
     */
    public static void main(String[] args) {
        // Example unsolved Sudoku board ('.' denotes empty cells)
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Input Sudoku Board:");
        printBoard(board);

        SudokuSolver solver = new SudokuSolver();
        solver.solveSudoku(board); // Solve the puzzle

        System.out.println("\nSolved Sudoku Board:");
        printBoard(board);
    }

    /**
     * Utility method to print the Sudoku board in a readable format.
     */
    public static void printBoard(char[][] board) {
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("------+-------+------");
            }
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
