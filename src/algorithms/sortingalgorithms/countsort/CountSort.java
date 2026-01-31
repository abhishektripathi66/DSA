public class CountSort {
    public static void countSort(int[] arr) {
        // Array's length 
        int n = arr.length;
        if (n == 0) return;

        // Find the maximum element in array 
        int maxElem = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > maxElem) {
                maxElem = arr[i];
            }
        }
        // Inititalize a count array with zeros 
        int[] countArr = new int[maxElem + 1];

        // Count elements in array 
        for (int num : arr) {
            countArr[num] ++; 
        }

        int curIndex = 0;
        int count;
        for (int i = 0; i < maxElem + 1; i++) {
            count = countArr[i]; 
            while (count > 0) {
                arr[curIndex++] = i;
                count --; 
            }
        }
    }

    // Test Block 
    public static void main(String[] args) { 
        int[] arr = {5, 8, 9, 1, 2, 6, 4};
        System.out.println("Before Count Sort:");
        printArray(arr);
        countSort(arr);
        System.out.println("After Count Sort:");
        printArray(arr);
    }

    // Print array method
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
} 