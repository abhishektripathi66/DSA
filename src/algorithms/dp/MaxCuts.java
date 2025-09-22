package algorithms.dp;

public class MaxCuts {
    public static void main(String[] args) {
        int n = 11; 
        int a = 2, b = 3, c = 5;
        
        System.out.println("Max cuts : "+maxCutsRec(n, a, b, c));
    }


    //Time Complexity: (3^n)
    private static int maxCutsRec(int n, int a, int b, int c){
        if(n < 0)
            return -1;
        
        if(n == 0)
            return 0;
        
        //take the maximum from valid cuts
        //by using math.max, -1 for invalid cut will be neglected here
        int res = Math.max(maxCutsRec(n-a, a, b, c), Math.max(maxCutsRec(n-b, a, b, c), maxCutsRec(n-c, a, b, c)));


        if(res  == -1) //no valid cut found
            return -1;
        else //add 1 for curr segment
            return res + 1;
    }
}
