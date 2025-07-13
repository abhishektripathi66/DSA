package StreamsApiquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ModifyingTheString {

    public static void main(String[] args) {
        
        List<String> string = new ArrayList<>(Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn"));

        String string1 = string.stream().collect(Collectors.joining(",","[","]"));
        System.out.println(string1);
    }
    
}
