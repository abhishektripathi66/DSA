package codingquestions.streamsapiquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortInReverseOrder {


    public static void main(String[] args) {

        List<Double> l = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

        l.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
