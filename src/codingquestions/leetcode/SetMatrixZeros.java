package codingquestions.leetcode;

import java.util.HashSet;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int matrix[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        find(matrix);
    }

    private static void find(int[][] matrix) {
        HashSet<Integer> zeroRows = new HashSet<>();
        HashSet<Integer> zeroCols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroCols.add(j);
                    zeroRows.add(i);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (zeroRows.contains(i) || zeroCols.contains(j)) {
                    matrix[i][j] = 0;
                }


            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }
    public static void setZeroes(int[][] matrix) {
        int row=0, m=matrix.length, n=matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    if(i==0){
                        row=1;
                    } else {
                        matrix[i][0]=0;
                        matrix[0][j]=0;
                    }   
                }
            }
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            for(int i=0; i<m; i++){
                matrix[i][0]=0;
            }
        }
        if(row==1){
            for(int j=0; j<n; j++){
                matrix[0][j]=0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
        
    }
}


/*
// this is best optimal appraoch using the boolean arrays 

int m=matrix.length;
        int n=matrix[0].length;

        boolean[] forRows= new boolean[m];
        boolean[] forCols= new boolean[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    forRows[i]=true;
                    forCols[j]=true;
                }
            }
        }//we marked the rows and cols with true

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(forRows[i] || forCols[j]){
                    matrix[i][j]=0;
                }
            }
        }
*/
