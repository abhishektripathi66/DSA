package codingquestions.codingninjas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSum {

    public static List<int[]> pairSum(int[] arr, int s) {
        // Write your code here.
        List<int[]> ls = new ArrayList<int[]>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                int[] x = new int[2];
                if ((arr[i] + arr[j]) == s) {

                    x[0] = arr[i];
                    x[1] = arr[j];

                    ls.add(x);
                }
            }
        }
        return ls;
    }
}
