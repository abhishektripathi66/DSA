package codingquestions.arrayinterviewquestion;

public class LargestElement {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        int largest = findLargestElement(arr);
        System.out.println("The largest element in the array is: " + largest);
    }

    //time complexity: O(n)
    //space complexity: O(1)
    public static int findLargestElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > largest)
                largest = arr[i];

        return largest;
    }
}