package algorithms.greedyalgorithms;

import java.util.Arrays;
/*
 * There are two main versions of the coin change problem:
 *
 * 1. 0/1 Coin Change (each coin can be used at most once)
 *    - Use Dynamic Programming (similar to 0/1 Knapsack)
 *    - Greedy approach does NOT work
 *
 * 2. Unbounded Coin Change (infinite supply of each coin)
 *    - Greedy approach works ONLY if the coin set is canonical
 *    - If the coin set is non-canonical, use Dynamic Programming to guarantee optimality
 *
 * Canonical Coin System:
 *    - A set of denominations where greedy always produces the minimum number of coins
 *    - Example: [1, 5, 10, 25]
 *    - Non-canonical Example: [1, 3, 4] → Greedy fails for amount = 6
 */


/*
 * Greedy Algorithm to find the minimum number of coins to make a given amount.
 * Assumes an infinite supply of each coin type.
 *
 * Time Complexity: O(n log n) for sorting + O(amount / min_coin)
 * Space Complexity: O(1)
 *
 * Example: coins = [1, 5, 10, 25], amount = 30 → Min coins = 2 (25 + 5)
 */


public class MinCoins {
    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        int amount = 30;

        int result = minCoinsCount(coins, amount);

        System.out.println("Min coins required: " + result);
    }

    private static int minCoinsCount(int[] coins, int amount) {
        // sort in descending order to apply greedy choice
        Arrays.sort(coins);
        reverse(coins);

        int count = 0;

        for (int coin : coins) {
            if (amount >= coin) {
                count += amount / coin;
                amount %= coin;
            }
        }

        //if amount is not 0, it means we cannot make the target with given coins
        return (amount == 0) ? count : -1;
    }

    // helper function to reverse the array
    private static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}
