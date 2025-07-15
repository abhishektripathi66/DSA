package codingquestions.streamsapiquestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PrintDuplicateCharacters {
    
    public static void main(String[] args) {
        String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
        Set<String> s = new HashSet<>();
        Set<String> duplicateElements = Arrays.stream(inputString.split("")).filter(i-> !s.add(i)).collect(Collectors.toSet());
        System.out.println(duplicateElements);
    }

}
