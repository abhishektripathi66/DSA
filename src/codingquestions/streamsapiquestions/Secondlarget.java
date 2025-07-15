package codingquestions.streamsapiquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Secondlarget {

    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        Integer b = a.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(b);
    }

}
