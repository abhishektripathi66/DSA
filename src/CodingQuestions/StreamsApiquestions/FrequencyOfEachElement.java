package StreamsApiquestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfEachElement {

    public static void main(String[] args) {
        
        List<String> l = Arrays.asList("string","apple","apple","bike","phone","string");
        
        Map<String,Long> m = l.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(m);
    }
    
}
