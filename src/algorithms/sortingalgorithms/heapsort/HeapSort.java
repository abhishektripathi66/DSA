package algorithms.sortingalgorithms.heapsort;

/*Algorithm for HeapSort */

public class HeapSort {

    public static void main(String[] args) {
        int array[] = {5, 8, 9, 1, 2, 6, 4};

        // Create instance of HeapSort and sort array
        HeapSort ob = new HeapSort();
        ob.sort(array);

        System.out.println("Sorted Array: ");
        printArray(array);
    }

    // printArray method
    static void printArray(int array[]) {
        int n = array.length;

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }

    // Heap Sort Method
    public void sort(int array[]) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i - 1];
            array[i - 1] = temp;

            heapify(array, i - 1, 0);
        }
    }

    // Heapify Method
    void heapify(int array[], int n, int y) {
        int largest = y;
        int left = 2 * y + 1;
        int right = 2 * y + 2;

        if (left < n) {
            if (array[left] > array[largest]) {
                largest = left;
            }
        }

        if (right < n) {
            if (array[right] > array[largest]) {
                largest = right;
            }
        }
        if (largest != y) {
            int swap = array[y];
            array[y] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }
}