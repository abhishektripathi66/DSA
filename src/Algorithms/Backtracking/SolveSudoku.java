/**
 * Sudoku Solver
 * 
 * This program solves a standard 9×9 Sudoku puzzle using backtracking.
 * The Gird is represented as a 2D array, where empty cells are denoted by 0.
 * 
 * The algorithm works recursively:
 * - It searches for the first empty cell in the grid.
 * - It tries placing digits from 1 to 9 in that cell.
 * - For each digit, it checks if placing the digit is valid:
 *   - Not already present in the current row
 *   - Not already present in the current column
 *   - Not already present in the 3×3 subgrid
 * - If valid, it places the digit and recursively solves the remaining puzzle.
 * - If placing a digit leads to a dead end, it backtracks and tries the next digit.
 * 
 * Time Complexity: O(9^(N×N)) (as each empty cell could potentially take one of 9 values.
 *                 However, due to constraint checking and backtracking, the actual runtime
 *                 is significantly reduced in practice.)
 * Space Complexity: O(1) additional space (modifies the board in-place)
 * 
 * Example Input Grid:
 * 3 0 6 5 0 8 4 0 0
 * 5 2 0 0 0 0 0 0 0
 * 0 8 7 0 0 0 0 3 1
 * 0 0 3 0 1 0 0 8 0
 * 9 0 0 8 6 3 0 0 5
 * 0 5 0 0 9 0 6 0 0
 * 1 3 0 0 0 0 2 5 0
 * 0 0 0 0 0 0 0 7 4
 * 0 0 5 2 0 6 3 0 0
 * 
 * A solved board will replace all 0s with valid digits.
 */


public class SolveSudoku {

    static int N = 9;
    static int[][] grid = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };;

    public static void main(String[] args){

        if (!isInitialGridValid()) {
            System.out.println("The given Sudoku puzzle is invalid and cannot be solved.");
            return;
        }
        
        if(solveSudoku()){
            System.out.println("Given Sudoku puzzle can be solved in following way.");
            printSolution();
        }
        else{
             System.out.println("Given Sudoku puzzle can not be solved.");
        }
    }

    private static boolean solveSudoku(){

        int i = 0, j = 0;

        for(i=0; i<N; i++){
            for(j=0; j<N; j++){
                //have to solve this point
                if(grid[i][j] == 0){
                    for(int n=1; n<=9; n++){ //try numbers from 1 to 9
                        if(isSafe(i, j, n)){
                            grid[i][j] = n;
                            if(solveSudoku()) //recursively check for other indexes 
                                return true;
                            grid[i][j] = 0; //backtrack if does not give valid solution
                        }
                    }

                    return false; //No valid number is found for current cell
                }
            }
        }

        
        return true; //no empty cells left; solution found
    }

    private static boolean isSafe(int i, int j, int n){

        for(int k=0; k<N; k++){
            //checking in row || checking in column
            if(grid[i][k] == n || grid[k][j] == n)
                return false;
        }
            
        
        //Incorrect
        //checking in 3x3 subgrid
        //int startI = i/3;
        //int startJ = j/3;

        int startI = (i / 3) * 3;
        int startJ = (j / 3) * 3;

        for(int x=startI; x<startI+3; x++){
            for(int y=startJ; y<startJ+3; y++){
                if(grid[x][y] == n)
                    return false;
            }
        }

        return true;
    }
    
    //to check initial values given in grid
    private static boolean isInitialGridValid() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            int num = grid[i][j];
            if (num != 0) {
                grid[i][j] = 0; // Temporarily remove the number to check validity
                if (!isSafe(i, j, num)) {
                    grid[i][j] = num; // Restore before returning
                    return false;
                }
                grid[i][j] = num; // Restore
            }
        }
    }
    return true;
}

    private static void printSolution(){
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
    }
}
