public class BinarySearch {
    
    /**
     * Performs a binary search on a sorted array.
     * 
     * @param arr The sorted array to search in
     * @param target The value to search for
     * @return The index of the target if found, -1 otherwise
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;             // Fixed: high should be arr.length - 1
        
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Prevents potential overflow
        
            if (arr[mid] == target) {
                return mid;                    // Target found
            } else if (arr[mid] < target) {
                low = mid + 1;                 // Target is in the upper half
            } else {
                high = mid - 1;                // Target is in the lower half
            }
        }
        return -1;                             // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};             // Sample sorted array
        int target = 10;                           // Value to search for
        
        int result = binarySearch(arr, target);
        
        if (result == -1) {
            System.out.println("Element " + target + " is not present in the array");
        } else {
            System.out.println("Element " + target + " found at index " + result);
        }
    }
}
