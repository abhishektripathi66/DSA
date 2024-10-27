/**
3334. Find the Maximum Factor Score of Array
Solved
Medium
Companies
Hint
You are given an integer array nums.

The factor score of an array is defined as the product of the LCM and GCD of all elements of that array.

Return the maximum factor score of nums after removing at most one element from it.

Note that both the LCM and GCD of a single number are the number itself, and the factor score of an empty array is 0.

The term lcm(a, b) denotes the least common multiple of a and b.

The term gcd(a, b) denotes the greatest common divisor of a and b.
  **/
class Solution {
    public long maxScore(int[] nums) {
        long bestScore = 0;
        int length = nums.length;
        bestScore = calculateScore(nums, -1);
        
        for (int skip = 0; skip < length; skip++) {
            long score = calculateScore(nums, skip);
            bestScore = Math.max(bestScore, score);
        }
        
        return bestScore;
    }
    
    private long calculateScore(int[] numbers, int skipIndex) {
        if (numbers.length == 0 || (numbers.length == 1 && skipIndex == 0)) {
            return 0;
        }
        
        if (numbers.length == 1 || (numbers.length == 2 && skipIndex >= 0)) {
            for (int i = 0; i < numbers.length; i++) {
                if (i != skipIndex) {
                    return (long)numbers[i] * numbers[i];
                }
            }
        }
        
        long currentGcd = 0;
        long currentLcm = 1;
        
        for (int i = 0; i < numbers.length; i++) {
            if (i != skipIndex) {
                if (currentGcd == 0) {
                    currentGcd = numbers[i];
                } else {
                    currentGcd = findGcd(currentGcd, numbers[i]);
                }
                currentLcm = findLcm(currentLcm, numbers[i]);
            }
        }
        
        return currentGcd * currentLcm;
    }
    
    private long findGcd(long first, long second) {
        while (second > 0) {
            long temp = second;
            second = first % second;
            first = temp;
        }
        return first;
    }
    
    private long findLcm(long first, long second) {
        return first * (second / findGcd(first, second));
    }
}
