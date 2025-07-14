package codingquestions.arrayinterviewquestion;

import java.util.Arrays;

/*
 * 
 * Given an image represented by an NxN matrix write a method to rotate the image by 90 degrees.
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
 */
public class MatrixRotation {

    public static void main(String[] args) {
        MatrixRotation mr = new MatrixRotation();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        mr.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - layer - 1;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }
}
