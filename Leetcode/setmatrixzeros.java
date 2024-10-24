import java.util.HashSet;

public class setmatrixzero {
    public static void main(String[]args)

    {
        int matrix[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2}, { 1, 3, 1, 5} };
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
                System.out.print(matrix[i][j]+" ");
                
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
