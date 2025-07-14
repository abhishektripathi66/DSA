package algorithms.searchingalogrithms.binarysearch;

public class FindAllOccurances {

    public static void main(String[] args) {
        System.out.println(findallocc(new int[]{1, 1, 3, 3, 3, 4, 5}, 3)); // Output: 3
        System.out.println(findcountOf1s(new int[]{0, 0, 0, 1, 1, 1, 1}));
        System.out.println(findcountOf1s(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}));
    }

    public static int findallocc(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int first = -1;
        int last = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) high = mid - 1;
            else if (arr[mid] < target) low = mid + 1;
            else {
                first = mid;
                high = mid - 1;
            }
        }
        if (first == -1) return 0;
        low = 0;
        high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) high = mid - 1;
            else if (arr[mid] < target) low = mid + 1;
            else {
                last = mid;
                low = mid + 1;
            }
        }

        return last - first + 1; // Return the count of occurrences


    }

    // sorted array of 0s and 1s is given, find the count of 1s
    public static int findcountOf1s(int[] arr) {

        int low = 0;
        int high = arr.length - 1;
        int first = -1;
        int last = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 0) low = mid + 1;
            else {
                first = mid;
                high = mid - 1;
            }
        }
        if (first == -1) return 0;
        return last - first; // Return the count of occurrences


    }

}
