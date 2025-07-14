package codingquestions.streamsapiquestions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeTwoUnsortedIntoSortedarray {


    public static void main(String[] args) {
        int[] a = new int[]{4, 2, 7, 1};

        int[] b = new int[]{8, 1, 9, 5};

        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
        System.out.println(Arrays.toString(c));
        //without duplicate

        int[] d = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().toArray();
        System.out.println(Arrays.toString(d));
    }
}
