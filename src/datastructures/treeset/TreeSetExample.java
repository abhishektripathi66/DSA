package datastructures.treeset;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {

        TreeSet<String> set = new TreeSet<>();

        set.add("Element1");
        set.add("Element2");
        set.add("Element3");
        set.add("Element1");

        set.remove("Element2");


        System.out.println("Iterating over TreeSet using for-each loop:");
        for (String element : set) {
            System.out.println(element);
        }

        boolean contains = set.contains("Element3");
        System.out.println("TreeSet contains 'Element3': " + contains);


        int size = set.size();
        System.out.println("Size of TreeSet: " + size);
        set.clear();
        System.out.println("Size of TreeSet after clear: " + set.size());
    }
}

