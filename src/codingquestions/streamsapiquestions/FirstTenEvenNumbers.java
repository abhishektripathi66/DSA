package streamsapiquestions;

import java.util.stream.IntStream;

public class FirstTenEvenNumbers {

    public static void main(String[] args) {
        
        IntStream.range(0,11).map(i->i*2).forEach(System.out::println);

    }
    
}
