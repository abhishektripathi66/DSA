package StreamsApiquestions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class FrequencyOfCharacters {

    public static void main(String[] args) {
        
        String a = "Java Concept of the day";
        Map<Character,Long> m = a.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(m);

        

    }
    
}
