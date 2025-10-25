package algorithms.dp;

public class MatrixChainMultiplication {
    public static void main(String[] args){
        int[] arr = {2, 1, 3, 4};
        int n = arr.length;

        System.out.println("Minimum number of multiplications : "+matrixChainMultiplicationRec(0, n-1, arr));
    }

    //Time complextity: O(2^n) and Auxilliary Space Complexity : O(n)
    private static int matrixChainMultiplicationRec(int i, int j, int[] arr){

        //partition must have atleast two elements

        //Base case: just one dimimension
        if( i + 1 == j)
            return 0;
    
        int res = Integer.MAX_VALUE;

        //for current window if there are n elements then there are n-1 ways to put brackets
        //try including different elements in current bracket
        for(int k=i+1; k<j; k++){
            
            //For every k, we make two subproblems : (a) Chain from i to k  (b) Chain from k to j
            int curr = (matrixChainMultiplicationRec(i, k, arr) + matrixChainMultiplicationRec(k, j, arr)) + arr[i]*arr[k]*arr[j];

            res = Math.min(res, curr);
        }
        
        //return minimum count
        return res;
    }
}
