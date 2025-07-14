package codingquestions.streamsapiquestions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseAnInteger {

    public static void main(String[] args) {
        
        int[] a = {5, 1, 7, 3, 9, 6};

        int[] b = IntStream.rangeClosed(1,a.length).map(i->a[a.length-i]).toArray();
        System.out.println(Arrays.toString(b));
    }
    
}


