package arrayspackage;

import java.util.Arrays;

public class Singledimensionarraytest {

    public static void main(String[] args) {
        
        var sda = new Singledimensionarray();
        sda.traversal();
        sda.init(4);
        System.out.println(Arrays.toString(sda.getarray()));
        sda.insert(0, 1);
        sda.insert(1, 2);
        sda.insert(2, 3);
        sda.insert(3, 4);
        sda.insert(4, 5);
        sda.insert(0, 3);
        System.out.println(Arrays.toString(sda.getarray()));
        System.out.println(sda.getElement(0));
        sda.traversal();
        sda.searchinarray(1);
        sda.searchinarray(7);
        sda.deletevalue(1);
        sda.traversal();
        sda.deletevalue(5);
    }
    
}
