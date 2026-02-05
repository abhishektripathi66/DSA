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
