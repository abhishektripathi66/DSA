package algorithms.sortingalgorithms.bucketsort;

import java.util.ArrayList;
import java.util.Arrays;
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
 * Bucket Sort implementation for double arrays.
 *
 * This algorithm works best when the input values
 * are uniformly distributed over a range.
 */
public class BucketSort {


    public static void main(String[] args) {
        double[] arr = {0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(double[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // Find min and max values
        double min = arr[0];
        double max = arr[0];

        for (double value : arr) {
            if (value < min) min = value;
            if (value > max) max = value;
        }

        // Create buckets (heuristic: sqrt(n))
        int numberOfBuckets = (int) Math.sqrt(arr.length);
        if (numberOfBuckets <= 0) {
            numberOfBuckets = 1;
        }

        List<List<Double>> buckets = new ArrayList<>();
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute elements into buckets
        double range = (max - min) / numberOfBuckets;

        for (double value : arr) {
            int bucketIndex;
            if (range == 0) {
                bucketIndex = 0;
            } else {
                bucketIndex = (int) ((value - min) / range);
                if (bucketIndex == numberOfBuckets) {
                    bucketIndex--;
                }
            }
            buckets.get(bucketIndex).add(value);
        }

        // Sort each bucket
        for (List<Double> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Merge buckets back into array
        int index = 0;
        for (List<Double> bucket : buckets) {
            for (double value : bucket) {
                arr[index++] = value;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 9, 1, 2, 6, 4, -3, 0, 8};

}
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Bucket Sort Algorithm
 * ----------------------
 * Distributes elements into various buckets and sorts
 * individual buckets using insertion sort
 * n is size of array, k is number of buckets
 * Time Complexity: Average O(n + k), Worst O(n^2)
 * Space Complexity: O(n + k)
 * Author: Trevin Fugere
 */
public class BucketSort {

      public static void insertionSort(List<Integer> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            int key = bucket.get(i);
            int j = i-1;
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }

    public static void bucketSort(int[] arr) {
        int n = arr.length;
        List<Integer>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        int maxVal = arr[0];
        for (int i : arr) {
            if (i > maxVal) {
                maxVal = i;
            }

        }
        for (int i = 0; i < n; i++) {
            int bi = ((n-1)*arr[i]) / maxVal;
            buckets[bi].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            insertionSort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index] = buckets[i].get(j);
                index++;

            }
        }
    }

  
    public static void main(String[] args) {
        int[] arr = {5, 8, 9, 1, 2, 6, 4};
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
package algorithms.sortingalgorithms.bucketsort;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

public class BucketSort {
    static void display(float[] arr) {
        for (float value : arr) {
            System.out.print(value + "  ");
        }
    }

    static void BucketSort(float[] arr) {
        int n = arr.length;

        float max = arr[0];
        for (float v : arr) {
            if (v > max)
                max = v;
        }
        // Bucket
        ArrayList<Float>[] buckets = new ArrayList[n];
        // create empty buckets
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<Float>();
        }
        // add element into our buckets
        for (int i = 0; i < n; i++) {
            // int bucketIndex = (int) (arr[i] * n);
            int bucketIndex = (int) ((arr[i] / max) * (n - 1));

            buckets[bucketIndex].add(arr[i]);
        }

        // Sort each bucket individually
        for (int i = 0; i < buckets.length; i++) {
            Collections.sort(buckets[i]);
        }
        // merge all buckets to get final sorted array
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            ArrayList<Float> currBucket = buckets[i];
            for (int j = 0; j < currBucket.size(); j++) {
                arr[index++] = currBucket.get(j);
            }
        }
    }

    public static void main(String[] args) {
        // put any value int float decimal easily work and give sorted order
        float[] arr = { 0.5f, 0.4f, 0.3f, 0.2f, 0.1f };
        BucketSort(arr);
        System.out.print("after sorted array:");
        display(arr);
    }

}
 
import java.util.*;

public class Main {

   


    public static void main(String[] args) {
          int[] arr = {2000 , 200 , 50 , 1};
       
        System.out.println(Arrays.toString(new DL().bucketSort(arr)));
        int bucket = (int) Math.ceil(num);

   }

}
