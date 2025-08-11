package algorithms.sortingalgorithms.bogosort;

import java.util.Arrays;
import java.util.Random;

/**
 * Algorithm for BogoSort:
 * <br>
 * BogoSort is (performance-wise) a terrible sorting algorithm, but really illustrates how bad O(n!)
 * complexity can get.
 * <br>
 * Feel free to uncomment bogosort(test2) to check how bad O(n!) gets even vor relatively small arrays
 */
public class BogoSort {
    public static void main(String[] args) {
        //initializing to test Arrays (size 4 vs. size 10)
        int[] test1 = {4,6,2,54};
        int[] test2 = {1,5,3,7,8,2,99,23,4,6};
        System.out.println("Begin BogoSort (short Array)");
        bogoSort(test1);
//        System.out.println("Begin BogoSort (long Array)");
//        bogoSort(test2);
    }

    static final Random RAND = new Random();

    /**
     * sorts the given Array by randomly shuffling until arr is sorted in ascending order
     * @param arr (int)
     */
    public static void bogoSort(int[] arr){
        int i = 1;
        System.out.println("Starting point: " + Arrays.toString(arr));
        while(!isSorted(arr)){
            System.out.printf("%d. Iteration:\n%s%n", i, Arrays.toString(arr));
            shuffle(arr);
            i++;
        }
        System.out.println("Finished: " + Arrays.toString(arr));
    }

    /**
     * Uses the Fisher Yates Algorithm to shuffle the array. Swaps with XOR Comparison
     * @param arr Array consisting of int
     */
    static void shuffle(int[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            int j = RAND.nextInt(i + 1);
            //XOR Swap
            if (i != j) {
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
            }
        }
    }

    /**
     * checks if array is sorted
     * @param arr
     * @return true if sorted in ascending order
     */
    static boolean isSorted(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }

}
