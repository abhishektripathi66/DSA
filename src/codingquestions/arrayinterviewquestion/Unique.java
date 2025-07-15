package codingquestions.arrayinterviewquestion;

import java.util.HashSet;

/*
 * Write a program to check if an array is unique or not.

Example

int[] intArray = {1,2,3,4,5,6};
isUnique(intArray) // true
 */
public class Unique {
    public static void main(String[] args) {
        Unique unique = new Unique();
        System.out.println(unique.isUnique2(new int[]{1, 2, 34, 4}));
    }

    public boolean isUnique(int[] intArray) {

        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] == intArray[j]) return false;
            }
        }
        return true;
    }

    public boolean isUnique2(int[] intArray) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < intArray.length; i++) {
            if (!set.add(intArray[i])) return false;
        }
        return true;
    }


}
