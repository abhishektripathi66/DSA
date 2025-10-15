package algorithms.dp;

public class OptimalStrategyForGame {
    public static void main(String[] args) {
        //even number of coins will be given
        int[] arr = {20, 5, 4, 6};
        int n = arr.length;

        System.out.println("Maximum value can be collected : "+optimalStrategyRec(arr, 0, n-1));
    }

    private static int optimalStrategyRec(int[] arr, int i, int j){
        //pointers surpass each other, no coins left
        if(i > j)
            return 0;

        //one coin left
        if(i == j)
            return arr[i];
        
        //when just two coins left
        if( i+1 == j)
            return Math.max(arr[i], arr[j]);
        
        //either we choose arr[i] or arr[j], opponent will choose in a way that we get min value in next moves
        //so we have to take maximum from both options
        return Math.max(arr[i] + Math.min(optimalStrategyRec(arr, i+2, j), optimalStrategyRec(arr, i+1, j-1)), 
        arr[j] + Math.min(optimalStrategyRec(arr, i+1, j-1), optimalStrategyRec(arr, i, j-2)));
    }
}
