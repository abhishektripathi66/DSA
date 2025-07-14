package codingquestions.generalquestions;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] a = new int[]{2, 3, 4, 5, 7, 8, -1};
        int target = 7;
        HashSet<Integer> s = new HashSet<>();
        for (int b : a) {
            s.add(b);
        }
        List<List<Integer>> l = new ArrayList<>();
        for (int b : a) {
            int c = target - b;
            if (!s.add(c)) {
                List<Integer> l1 = new ArrayList<>();
                l1.add(b);
                l1.add(c);
                l.add(l1);
            }

        }
        System.out.println(l);

    }

}