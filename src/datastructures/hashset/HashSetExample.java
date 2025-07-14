package datastructures.hashset;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();


        set.add("Element1");
        set.add("Element2");
        set.add("Element3");
        set.add("Element1");

        set.remove("Element2");


        System.out.println("Iterating over HashSet using for-each loop:");
        for (String element : set) {
            System.out.println(element);
        }

        boolean contains = set.contains("Element3");
        System.out.println("HashSet contains 'Element3': " + contains);

        int size = set.size();
        System.out.println("Size of HashSet: " + size);

        set.clear();
        System.out.println("Size of HashSet after clear: " + set.size());
    }
}

