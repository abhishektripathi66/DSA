package codingquestions.arrayinterviewquestion;

import java.util.*;

public class MinMaxPairing {

    public static void main(String[] args) {
        int[] arr = {-5, -2, -3, 4, 6, 1};
        List<int[]> result = minimizeMaxPairSum(arr);

        System.out.println("Pairs:");
        for (int[] p : result) {
            System.out.println(Arrays.toString(p) + " Sum: " + (p[0] + p[1]));
        }
    }

    // Time complexity: O(n log n)
    // Space complexity: O(n)
    public static List<int[]> minimizeMaxPairSum(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length % 2 != 0) {
            throw new IllegalArgumentException("Invalid array");
        }

        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();

        for (int num : arr) {
            if (num < 0) negatives.add(num);
            else positives.add(num);
        }

        Collections.sort(negatives);
        positives.sort(Collections.reverseOrder());

        List<int[]> pairs = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < negatives.size(); i++) {
            int[] pair = new int[]{negatives.get(i), positives.get(i)};
            pairs.add(pair);
            maxSum = Math.max(maxSum, pair[0] + pair[1]);
        }

        System.out.println("Minimal possible maximum sum: " + maxSum);
        return pairs;
    }
}
