package codingquestions.streamsapiquestions;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoStringsAnagram {

    public static void main(String[] args) {

        String s1 = "RaceCar";
        String s2 = "CarRace";
        s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

        if (s1.equals(s2)) System.out.println("Two strings are anagrams");
        else System.out.println("two strings are not anagrams");
    }

}
