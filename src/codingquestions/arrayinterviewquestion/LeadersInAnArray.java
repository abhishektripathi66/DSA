package codingquestions.arrayinterviewquestion;

public class LeadersInAnArray {

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 10, 6, 5, 2};
        printLeaders(arr);
    }

    // time complexity: O(n)
    // space complexity: O(1)
    // A leader is an element which is greater than all the elements to its right side.
    // The rightmost element is always a leader.
    // Example: 7,10,4,10,6,5,2 => 10,6,5,2 are leaders
    // Explanation: 10 > 4,6,5,2 => 6 > 5,2 => 5 > 2 => 2 is the rightmost element and is always a leader.
    public static void printLeaders(int[] arr) {
        int a = arr[arr.length - 1];
        System.out.print(a + ", ");
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > a) {
                System.out.print(arr[i] + ", ");
                a = arr[i];
            }
        }
    }
}