package codingquestions.leetcode;

public class MaximumBalancedShipments {

    public static void main(String[] args) {
        System.out.println(maxBalancedShipments(new int[]{2, 5, 1, 4, 3})); // Output: 2
        System.out.println(maxBalancedShipments(new int[]{4, 4}));         // Output: 0
        System.out.println(maxBalancedShipments(new int[]{1, 3, 2, 5, 4, 6, 1})); // Output: 3
    }

    public static int maxBalancedShipments(int[] weight) {
        int n = weight.length;
        int count = 0;
        int i = 0;

        while (i < n) {
            int maxWeight = weight[i];
            int j = i;

            while (j < n) {
                maxWeight = Math.max(maxWeight, weight[j]);

                // If the last parcel weight is strictly less than the max, it's balanced
                if (weight[j] < maxWeight) {
                    count++;
                    i = j + 1; // move to next parcel after shipment
                    break;
                }

                j++;
            }

            // If we reach end without finding a balanced shipment
            if (j == n) break;

            // if shipment formed, i is already moved
        }

        return count;
    }
    
}
