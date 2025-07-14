package codingquestions.arrayinterviewquestion;

public class MoveAllZerosToEnd {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12, 0, 5};
        moveZeroesToEnd(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    //time complexity: O(n)
    //space complexity: O(1)
    // This function moves all zeros in the array to the end while maintaining the order of non-zero elements.
    public static int moveZeroesToEnd(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }

        return j; // returns the count of non-zero elements
    }
}
