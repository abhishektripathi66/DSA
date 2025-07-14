package codingquestions.leetcode;

import java.util.Arrays;

/**
 * 2064. Minimized Maximum of Products Distributed to Any Store
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an integer n indicating there are n specialty retail stores. There are m product types of varying amounts, which are given as a 0-indexed integer array quantities, where quantities[i] represents the number of products of the ith product type.
 * <p>
 * You need to distribute all products to the retail stores following these rules:
 * <p>
 * A store can only be given at most one product type but can be given any amount of it.
 * After distribution, each store will have been given some number of products (possibly 0). Let x represent the maximum number of products given to any store. You want x to be as small as possible, i.e., you want to minimize the maximum number of products that are given to any store.
 * Return the minimum possible x.
 * <p>
 * <p>
 * Solution
 * Intuition
 * The problem aims to find the smallest maximum number of products that can be allocated to a store while distributing the quantities among n stores. To achieve this, we can use a binary search approach to minimize the maximum number of products (item) allocated per store.
 * <p>
 * The function solve checks whether it’s possible to allocate quantities such that each store gets no more than item products, and no more than n stores are used.
 * <p>
 * Approach
 * Binary Search:
 * • We define low as 1 and high as the maximum number of products in quantities. This represents the possible range of values for item.
 * • We use binary search to find the smallest value of item that allows distributing all products among n stores.
 * Feasibility Check (solve function):
 * • For each value of item, we determine if it's feasible to allocate the products such that no store receives more than item products.
 * • For each quantity, calculate how many stores are needed if each store receives a maximum of item products using (product - 1) / item + 1 (equivalent to ceil(product / item)).
 * • If the total number of stores required exceeds n, this value of item is too small, so we need to increase item.
 * • If the number of stores required is within n, then this value of item is feasible, so we attempt to find a smaller maximum by setting high = mid - 1.
 * Updating Answer:
 * • If solve returns true, we store mid as a potential answer and continue to search for a smaller feasible maximum by updating high.
 * • Otherwise, we update low to search in the higher range of values.
 * Result:
 * • When the binary search completes, ans contains the smallest feasible maximum number of products per store.
 * Complexity
 * Time complexity:
 * O(m * log(max(quantities))).
 * Space complexity:
 * O(1)
 **/

public class MinimizedMaximumofProductsDistributedtoAnyStore {
    private boolean solve(int n, int[] quantities, int item) {
        if (item == 0) return false;
        int store = 0;
        for (int product : quantities) {
            store += (product - 1) / item + 1;
            if (store > n) return false;
        }
        return true;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Arrays.stream(quantities).max().getAsInt();
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (solve(n, quantities, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
