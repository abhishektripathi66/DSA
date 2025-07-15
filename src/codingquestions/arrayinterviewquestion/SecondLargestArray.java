package codingquestions.arrayinterviewquestion;

public class SecondLargestArray {

    public static void main(String[] args) {
        System.out.println(secondLargestArray(new int[]{1, 2, 3, 4, 5}));
        System.out.println(secondLargestArray(new int[]{10, 10, 10, 10, 10}));
    }

    // time complexity: O(n)
    // space complexity: O(1)
    public static int secondLargestArray(int[] arr) {
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != firstLargest) {
                secondLargest = arr[i];
            }
        }
        secondLargest = (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest; // If no second largest found, return -1
        return secondLargest;
    }

}
