package codingquestions.arrayinterviewquestion;

public class Equilibrium {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 2, 3};
        System.out.println(findEquilibriumIndex(arr)); // Output: 3
        System.out.println(threePartPossible(arr)); // Output: 3
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

    public static boolean threePartPossible(int[] arr) {
        int totalsum = 0;
        for (int num : arr) {
            totalsum += num;
        }
        if (totalsum % 3 != 0) return false;
        int partsum = totalsum / 3;
        int count = 0;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum == partsum) {
                count++;
                currentSum = 0; // Reset current sum for the next part  
            }
        }
        if (count == 3) return true; // Found three parts with equal sum
        return false; // Not possible to divide into three parts with equal sum
    }
}
