package codingquestions.generalquestions;

public class TwoOddOccurance {

    public static void main(String[] args) {
        // twodd(new int[]{7,3,7,7,3,3,6,6});
        twoddoptimized(new int[]{7, 3, 7, 7, 3, 3, 6, 6});
    }

    // time complexity: O(n^2)
    // space complexity: O(1)
    public static void twodd(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) count++;
            }
            if (count % 2 != 0) {
                System.out.println(arr[i]); // Return the element that occurs an odd number of times
            }
        }

    }

    // time complexity: O(n)
    // space complexity: O(1)
    public static void twoddoptimized(int[] arr) {
        int xor = 0;
        for (int a : arr) {
            xor ^= a;
        }

        int setBit = xor & ~(xor - 1); // Get the rightmost set bit
        int num1 = 0, num2 = 0;
        for (int a : arr) {
            if ((a & setBit) != 0) {
                num1 ^= a; // First number with the set bit
            } else {
                num2 ^= a; // Second number without the set bit
            }
        }

        System.out.println(num1); // First odd occurrence
        System.out.println(num2); // Second odd occurrence
    }
}
