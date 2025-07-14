package codingquestions.leetcode;

public class FindNonDuplicate {

    public static void main(String[] args) {
        System.out.println(FindNonDuplicate.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
            System.out.println(result);
        }
        return result;
    }
}
