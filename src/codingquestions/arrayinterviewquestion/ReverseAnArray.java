package codingquestions.arrayinterviewquestion;

public class ReverseAnArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] reversedArr = reverseAnArray(arr);
        if (reversedArr != null) {
            for (int num : reversedArr) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            System.out.println("Array is null or empty");
        }
        arr = new int[]{1, 2, 3, 4};
        reversedArr = reverseAnArray(arr);
        if (reversedArr != null) {
            for (int num : reversedArr) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            System.out.println("Array is null or empty");
        }
    }

    // time complexity: O(n/2) - since we are swapping elements from both ends towards the center
    // space complexity: O(1)
    public static int[] reverseAnArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

}
