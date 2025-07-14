package codingquestions.streamsapiquestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheMostRepeatedNumber {
    

    public static void main(String[] args) {
        
        List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");

        Map<String,Long> m = listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        Entry<String,Long> e = m.entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.print("Most frequent Element : "+e.getKey());

        System.out.println(" Count : "+e.getValue());

    }
}
