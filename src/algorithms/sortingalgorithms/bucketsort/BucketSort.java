package algorithms.sortingalgorithms.bucketsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Bucket Sort Algorithm
 * ---------------------
 * A distribution-based sorting algorithm that distributes elements into a number of buckets,
 * sorts each bucket individually, and then concatenates the buckets to form the final sorted array.
 * <p>
 * This implementation supports negative numbers and duplicates by using (min, max) to map values
 * into buckets.
 * <p>
 * Time Complexity: O(n + k + Σ sort(bucket_i)) average (often near O(n) for uniform data),
 * O(n^2) worst case (when most elements fall into one bucket).
 * Space Complexity: O(n + k) due to buckets.
 * <p>
 * Author: Your Name
 */
public class BucketSort {

    /**
     * Sorts the array using Bucket Sort with a default bucket size.
     *
     * @param arr the array to sort
     */
    public static void bucketSort(int[] arr) {
        bucketSort(arr, 10);
    }

    /**
     * Sorts the array using Bucket Sort.
     *
     * @param arr the array to sort
     * @param bucketSize the range span for each bucket (must be > 0)
     */
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        if (bucketSize <= 0) {
            throw new IllegalArgumentException("bucketSize must be greater than 0");
        }

        int min = arr[0];
        int max = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }

        int bucketCount = ((max - min) / bucketSize) + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int value : arr) {
            int bucketIndex = (value - min) / bucketSize;
            buckets.get(bucketIndex).add(value);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 9, 1, 2, 6, 4, -3, 0, 8};

        System.out.println("Before Bucket Sort:");
        printArray(arr);

        bucketSort(arr);

        System.out.println("After Bucket Sort:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
