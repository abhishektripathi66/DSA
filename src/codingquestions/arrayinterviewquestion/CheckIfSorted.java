package codingquestions.arrayinterviewquestion;

public class CheckIfSorted {

    public static void main(String[] args) {

    }

    // time complexity: O(n)
    // space complexity: O(1)
    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }
}
