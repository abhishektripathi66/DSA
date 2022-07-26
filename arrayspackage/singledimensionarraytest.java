package arrayspackage;

import java.util.Arrays;

public class singledimensionarraytest {

    public static void main(String[] args) {
        
        var sda = new singledimensionarray();
        sda.init(4);
        System.out.println(Arrays.toString(sda.getarray()));
        sda.insert(0, 1);
        sda.insert(1, 2);
        sda.insert(2, 3);
        sda.insert(3, 4);
        sda.insert(4, 5);
        sda.insert(0, 3);
        System.out.println(Arrays.toString(sda.getarray()));
    }
    
}
