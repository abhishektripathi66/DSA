package GreedyAlgorithms;

import java.util.Comparator;
import java.util.Arrays;


/*
 * Fractional Knapsack Problem
 * 
 * Given a list of items, with a value and weight, and a knapsack with a limited capacity. Get maximum total value in the knapsack by selecting whole or fractional parts of items. 
 * Unlike the 0/1 Knapsack Problem, we are allowed to  take fractional parts.
 *
 * Time Complexity: O(n log n) for sorting items
 * Space Complexity: O(n) for storing items
 *
 * Example:
 *   val = [60, 100, 120], wt = [10, 20, 30], capacity = 50
 *   → Max value = 240.0
 */

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;

        System.out.println(getMaxValue(val, wt, capacity));

    }

    private static double getMaxValue(int[] val, int[] wt, int capacity){
        int n = val.length;

        //create 2-D array to bind both value and weight
        int[][] items = new int[n][2];

        for(int i=0; i<n; i++){
            items[i][0] = val[i];
            items[i][1] = wt[i];
        }

        //sorting based on most profitable item per weight
        Arrays.sort(items, new ItemsComparator());
        
        double res = 0;
        int currentCapacity = capacity;
        //traversing in reversly sorted array
        for(int i=0; i<n; i++){
            //if current item weight is less than capacity, take entire item
            if(items[i][1] <= currentCapacity){
                res += items[i][0];
                currentCapacity -= items[i][1];                
            }
            else{ //else take fraction part of it
                res += ((double)currentCapacity/items[i][1])*items[i][0];
                currentCapacity = 0;
                break;
            }
        }

        return res;
    }

    //it will conversely sort items based on value by weight
    static private class ItemsComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            double compareValue = (double)b[0]/b[1] - (double)a[0]/a[1];
            if(compareValue > 0)
                return 1;
            else if(compareValue == 0)
                return 0;
            else
                return -1;
        }
    }
}
