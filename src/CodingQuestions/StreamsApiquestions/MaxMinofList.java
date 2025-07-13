package StreamsApiquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxMinofList {

    public static void main(String[] args) {
        
        List<Integer> l = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        int max = l.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max);
        int min = l.stream().min(Comparator.reverseOrder()).get();
        System.out.println(min);
    }
    
}
