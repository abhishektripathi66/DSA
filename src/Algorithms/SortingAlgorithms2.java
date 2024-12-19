/*Bubble sort, Selection sort and Insertion sort Algorithms using iterative approach*/

public class SortingAlgorithms2 {

    public static void main(String[] args) {
        int arr[] = { 5, 8, 9, 1, 2, 6, 4 };

        System.out.println("Original Array:");
        printArray(arr);

        bubbleSort(arr);
        System.out.println("After Bubble Sort:");
        printArray(arr);

        // Reset the array for subsequent sorts
        arr = new int[] { 5, 8, 9, 1, 2, 6, 4 }; 

        selectionSort(arr);
        System.out.println("After Selection Sort:");
        printArray(arr);

        // Reset the array for subsequent sorts
        arr = new int[] { 5, 8, 9, 1, 2, 6, 4 }; 

        insertionSort(arr);
        System.out.println("After Insertion Sort:");
        printArray(arr);
    }

    /**
     * Sorts an array using the Bubble Sort algorithm.
     * Time Complexity: O(n^2) in the worst and average case.
     * Space Complexity: O(1)
     *
     * @param arr the array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts an array using the Selection Sort algorithm.
     * Time Complexity: O(n^2) in all cases.
     * Space Complexity: O(1)
     *
     * @param arr the array to be sorted
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * Sorts an array using the Insertion Sort algorithm.
     * Time Complexity: O(n^2) in the worst case, O(n) in the best case.
     * Space Complexity: O(1)
     *
     * @param arr the array to be sorted
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
