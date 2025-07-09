import java.util.Scanner;

/*
 * N-Queens Problem
 * The goal is to place N queens on an N×N chessboard such that no two queens threaten each other.
 * 
 *
 * The solution uses backtracking to explore all valid placements.
 * At each column, we try to place a queen in a safe row, and recursively place the next queen.
 * If no safe position is found, we backtrack to try a different arrangement.
 * 
 *
 * Time Complexity: O(N!) in the worst case (due to trying all permutations of queen placements)
 * Space Complexity: O(N^2) for the board representation
 *
 * Example:
 * For N = 4, one of the valid solutions is:
 * 0 1 0 0
 * 0 0 0 1
 * 1 0 0 0
 * 0 0 1 0
 *
 * Each '1' represents a queen and '0' represents an empty space.
 */


public class NQueen {

    static int N;
    static int board[][]; 

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of queens : ");
        N = sc.nextInt();
        sc.close();

        if (N < 1) {
            System.out.println("Number of queens must be at least 1.");
            return;
        }


        board = new int[N][N]; //will be empty at the first

        if(NQueenRec(0)){
            System.out.println(N+" queens can be placed on the board in the following way.");
            printSolution();
        }
        else{
            System.out.println(N+" Queens can not be placed on given board.");
        }


    }

    private static boolean NQueenRec(int col){ //checking for current column

        if(col == N){ //if all queens are placed well in each columns
            return true;
        }


        for(int i=0; i<N; i++){ //iterating through different row of given column
           
            if(isSafe(i, col)){
                board[i][col] = 1;
                
                //check for next column
                if(NQueenRec(col+1))
                    return true;

                board[i][col] = 0; //backtrack if not working
            }
            
        }
        return false;
    }
    

    private static boolean isSafe(int row, int col){
        //Incorrect way, it will place each queen in first row
        //check in the all rows in given column
        //we just validate row, because column validation is done in recursive function
        // for(int i=0; i<row; i++){
        //     if(board[i][col] == 1)
        //         return false;
        // }


        //check the left side of the current row for any previously placed queens
        //since we place one queen per column from left to right, 
        //we only need to check earlier columns in the same row.
        for(int i=0; i<col; i++){
            if(board[row][i] == 1)
                return false;
        }


        //check for upper diagonal
        for(int i=row, j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 1)
                return false;
        }

        //check for lower diagonal
        for(int i=row, j=col; i<N && j>=0; i++,j--){ //j-- for checking for previous columns
            if(board[i][j] == 1)
                return false;
        }

        return true;
    }

    private static void printSolution(){
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
}
