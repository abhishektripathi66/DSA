package codingquestions.streamsapiquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortIncreasingOrder {

    public static void main(String[] args) {
        List<String> a = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        a.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }

}
