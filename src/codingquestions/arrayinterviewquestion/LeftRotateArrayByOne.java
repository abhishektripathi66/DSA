package codingquestions.arrayinterviewquestion;

public class LeftRotateArrayByOne {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        leftrotatearray(arr, 5);
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void leftrotatearray(int[] arr, int a) {
        if (a > arr.length - 1) a %= arr.length;
        int[] arr1 = new int[a];
        for (int i = 0; i < a; i++) {
            arr1[i] = arr[i];
        }
        int j = 0;
        for (int i = a; i < arr.length; i++) {
            arr[j++] = arr[i];
        }

        for (int i = 0; i < a; i++) {
            arr[j++] = arr1[i];
        }
    }

    public static void leftRotateArrayeff(int[] arr, int n, int d) {
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            high++;
            low--;
        }
    }
}
