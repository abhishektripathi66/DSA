package codingquestions.arrayinterviewquestion;

public class PrefixSum {

    public static void main(String[] args) {
        int[] arr = {2, 8, 3, 9, 6, 5, 4};
        Queries queries = new Queries(arr);
        System.out.println(queries.getSum(0, 2)); // Output: 22
        System.out.println(queries.getSum(1, 3)); // Output: 27
        System.out.println(queries.getSum(2, 6)); // Output: 26
        System.out.println(queries.getWeightedSum(0, 2)); // Output: 22
        System.out.println(queries.getWeightedSum(2, 3)); // Output:
    }

}

class Queries {
    private int[] prefixSum;
    private int[] weightedSum;

    public Queries(int[] arr) {
        prefixSum = new int[arr.length];
        weightedSum = new int[arr.length];
        prefixSum[0] = arr[0];
        weightedSum[0] = arr[0] * 1; // Assuming the first element has a weight of 1
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
            weightedSum[i] = weightedSum[i - 1] + arr[i] * (i + 1);
        }
    }

    public int getSum(int start, int end) {
        if (start == 0) {
            return prefixSum[end];
        } else {
            return prefixSum[end] - prefixSum[start - 1];
        }
    }

    public int getWeightedSum(int start, int end) {
        if (start == 0) return weightedSum[end];
        else return weightedSum[end] - weightedSum[start - 1];
    }
}
