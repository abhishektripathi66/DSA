package arrayspackage;

import java.util.Arrays;

public class twodimenisonarray {
    
    public static void main(String[] args) {
        
    
    //step 1 Declare
    int[][] arr;

    //step 2 Instantiate the array
    arr = new int[2][2];
    //step 3 initialise
    arr[0][0]=0;
    arr[0][1]=1;
    arr[1][0]=2;
    arr[1][1]=3;
    int[][] arr1 = {{1,2,3,4,5},{6,7,8,9,10}};
    System.out.println(Arrays.deepToString(arr));
    System.out.println(Arrays.deepToString(arr1));
    }
}
