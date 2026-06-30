package algorithms.sortingalgorithms.stalinsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Stalin Sort Algorithm
 * Removes elements that violate non-decreasing order.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Note: This is a humorous / educational algorithm.
 */
public class StalinSort {

    // Implementation of stalin sort
    public static List<Integer> sort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        if (arr.length == 0) return result;

        result.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= result.get(result.size() - 1)) {
                result.add(arr[i]);
            }
        }
        return result;
    }

    
    private static void printArray(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 23, 13, 8, 6, 7, 2};
        List<Integer> result = StalinSort.sort(arr);
        printArray(result);
    }
}
