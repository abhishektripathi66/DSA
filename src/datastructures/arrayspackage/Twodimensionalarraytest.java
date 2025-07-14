package datastructures.arrayspackage;

import java.util.Arrays;

public class Twodimensionalarraytest {
    public static void main(String[] args) {
        Twodimensionalarray tda = new Twodimensionalarray(2, 2);
        System.out.println(Arrays.deepToString(tda.arr));
        tda.insertelementinarray(0, 0, 0);
        tda.insertelementinarray(0, 1, 1);
        tda.insertelementinarray(1, 0, 2);
        tda.insertelementinarray(1, 1, 3);
        System.out.println(Arrays.deepToString(tda.arr));
        tda.accesscell(1, 1);
        tda.traverseArray();
        tda.searchValue(3);
        tda.searchValue(5);
        tda.deletevalue(1, 1);
        tda.traverseArray();
    }


}
