package codingquestions.streamsapiquestions;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static void main(String[] args) {

        List<String> l = Arrays.asList("Java", "Springboot", "Java", "Python");

        List<String> uniqueString = l.stream().distinct().collect(Collectors.toList());

        for (String a : uniqueString) {
            System.out.println(a);
        }

    }

}
