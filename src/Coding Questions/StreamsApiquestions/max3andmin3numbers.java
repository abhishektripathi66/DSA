package StreamsApiquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class max3andmin3numbers {

    public static void main(String args[]){

        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        listOfIntegers.stream().sorted().limit(3).forEach(System.out::println);

        listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
    }
    
}
