public class ternarysearch {

    // Function to perform Ternary Search
    public static int ternarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;

            // Check if element is at any mid
            if (arr[mid1] == x)
                return mid1;
            if (arr[mid2] == x)
                return mid2;

            // Decide which segment to search
            if (x < arr[mid1])
                return ternarySearch(arr, l, mid1 - 1, x);
            else if (x > arr[mid2])
                return ternarySearch(arr, mid2 + 1, r, x);
            else
                return ternarySearch(arr, mid1 + 1, mid2 - 1, x);
        }
        return -1; // element not found
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
        int x = 11;

        int index = ternarySearch(arr, 0, arr.length - 1, x);
        if (index != -1)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Element not found.");
    }
}
