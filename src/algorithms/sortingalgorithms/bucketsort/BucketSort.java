package algorithms.sortingalgorithms.bucketsort;
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
