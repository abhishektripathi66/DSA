package Leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class MaxInList {

    public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
    

       // 1st highest number
    // then
    Integer max = listOfIntegers
      .stream()
      .mapToInt(v -> v)
      .max().getAsInt();

      // 2nd highest number
      List<Integer> sortedUniqueNumbers = listOfIntegers.stream()
               .distinct()  // remove duplicates
               .sorted()    // sort
               .collect(Collectors.toList()); 
      
     System.out.println(Collections.max(listOfIntegers));
     System.out.println(sortedUniqueNumbers.get(sortedUniqueNumbers.size()-2));
     System.out.println(max);
    }
}