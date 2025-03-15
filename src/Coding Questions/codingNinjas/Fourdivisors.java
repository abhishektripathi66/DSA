package codingNinjas;

import java.util.ArrayList;

/**
 * "ninja-was-planning-to-propose-to-his-crush-nina-with-his-spectacular-martial-arts-moves-but-nina-was-more-interested-in-numbers-and-divisors-so-she-gave-ninja-a-challenge-to-complete-if-ninja-solves-it-only-then-she-will-date-him"
Nina gave him an array of positive integers, ‘ARR’ and asked him to find the sum of divisors of the integers in ‘ARR’ with exactly four divisors. In case there is no such integer with exactly four divisors, then the answer is 0. Ninja has been struggling for a very long time, so he needs your help to solve the problem.
The first line of input contains an integer 'T' representing the number of test cases.

The first line of each test case contains an integer ‘N’ representing the number of integers in the array, ‘ARR’.

The second line of each test case contains ‘N’ space-separated integers representing the elements of the ‘ARR’ array.
For each test case, return the sum of divisors of the integers in ‘ARR’ with exactly four divisors. In case there is no such integer with exactly four divisors, then return 0.

The output of each test case will be printed in a separate line.
 */
public class Fourdivisors {

    public static int sumFourDivisors(ArrayList<Integer> arr, int n) {
        // Write your code here.
        int returnSum = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int count = 0;
            for (int j = 1; j <= arr.get(i) / 2; j++) {
                if (arr.get(i) % j == 0) {
                    count++;
                    sum += j;
                }
            }
            count++;
            sum += arr.get(i);
            if (count == 4) {
                returnSum += sum;
            }
        }
        return returnSum;
    }
}
