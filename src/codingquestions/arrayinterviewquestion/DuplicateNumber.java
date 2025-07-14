package codingquestions.arrayinterviewquestion;

import java.util.Arrays;

/*
 * Write a function to find the duplicate number on given integer array.

Example

removeDuplicates({1, 1, 2, 2, 3, 4, 5})
Output : [1, 2, 3, 4, 5]
 */
public class DuplicateNumber {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(duplicatenumber.removeDuplicates(new int[]{1, 1, 2, 2, 3, 4, 5})));
    }

    public static int[] removeDuplicates(int[] arr) {
        Arrays.sort(arr);
        int test = 0;
        int inc = 0;
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || test != arr[i]) {
                arr1[inc] = arr[i];
                inc++;
                test = arr[i];
            }
        }
        int[] arr2 = new int[inc];
        for (int i = 0; i < inc; i++) {

            arr2[i] = arr1[i];

        }
        return arr2;
    }

    private static int removeDuplicates(int a[], int n) {

        if (n == 0 || n == 1) {

            return n;

        }

        int j = 0;

        for (int i = 0; i < n - 1; i++) {

            if (a[i] != a[i + 1]) {

                a[j++] = a[i];

            }

        }

        a[j++] = a[n - 1];

        return j;

    }


    public static int[] removeDuplicates1(int[] arr) {

        int result = removeDuplicates(arr, arr.length);

        int[] newArray = new int[result];

        for (int i = 0; i < result; i++) {

            newArray[i] = arr[i];

        }

        return newArray;

    }


}
