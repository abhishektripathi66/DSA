package ArrayInterviewQuestion;

public class Equilibrium {
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 2};
        System.out.println(findEquilibriumIndex(arr)); // Output: 3
    }

    public static boolean findEquilibriumIndex(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (leftSum == totalSum - leftSum - arr[i]) {
                return true; // Found the equilibrium index
            }
            leftSum += arr[i];
        }

        return false; // No equilibrium index found
    }
}
