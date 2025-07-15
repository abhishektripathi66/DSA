package codingquestions.streamsapiquestions;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SeparateOddEven {

    public static void main(String[] args) {


        List<Integer> l = Arrays.asList(71, 18, 42, 21, 32, 43, 56, 65);

        Map<Boolean, List<Integer>> m = l.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));

        Set<Entry<Boolean, List<Integer>>> entry = m.entrySet();

        for (Entry<Boolean, List<Integer>> e : entry) {
            if (e.getKey()) {
                System.out.println("even numbers");

            } else {
                System.out.println("odd numbers");
            }
            List<Integer> l1 = e.getValue();
            for (int i : l1) {
                System.out.println(i);
            }
        }

    }


}
