public class ExponentialSearchAlgorithm {

    public static int binarySearch(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;
        if (arr[0] == target) {
            return 0;
        }
        int i = 1;
        while (i < n && arr[i] <= target) {
            i = i * 2;
        }
        return binarySearch(arr, target, i / 2, Math.min(i, n - 1));
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40, 50, 60, 70, 80, 90};
        int target = 10;
        int result = exponentialSearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in array.");
        }
    }
}
