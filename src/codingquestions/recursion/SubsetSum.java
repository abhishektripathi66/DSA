package codingquestions.recursion;

public class SubsetSum {


    public static void main(String[] args) {
        System.out.println(getnumberofSubset(3, 25, new int[]{10, 20, 15}));
        System.out.println(getnumberofSubset(3, 0, new int[]{10, 20, 15}));
        System.out.println(getnumberofSubset(5, 15, new int[]{10, 5, 2, 3, 6}));
    }

    // time complexity: O(2^n)
    // space complexity: O(n)
    public static int getnumberofSubset(int n, int sum, int[] arr) {
        if (n == 0)
            return sum == 0 ? 1 : 0;

        return getnumberofSubset(n - 1, sum - arr[n - 1], arr) +
                getnumberofSubset(n - 1, sum, arr);

    }
}
