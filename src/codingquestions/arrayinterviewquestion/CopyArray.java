package codingquestions.arrayinterviewquestion;

import java.util.Arrays;

/*
 * copy array by skipping first and last element
 */
public class CopyArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(middle(new int[]{1, 2, 3, 4})));
    }

    static int[] middle(int[] arr) {
        return Arrays.copyOfRange(arr, 1, arr.length - 1);
    }

}
