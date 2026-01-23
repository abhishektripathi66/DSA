package algorithms.sortingalgorithms.bucketsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
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
}