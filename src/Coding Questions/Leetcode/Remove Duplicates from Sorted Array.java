public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int k = 1; // Initialize the count of unique elements to 1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i]; // Overwrite the next unique element
                k++;
            }
        }
        
        return k;
    }
}
