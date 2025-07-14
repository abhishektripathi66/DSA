/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.


Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

Runtime: 1 ms, faster than 99.76% of Java online submissions for Trapping Rain Water.
Memory Usage: 48.3 MB, less than 76.32% of Java online submissions for Trapping Rain Water.
 * 
 */
public class TappingRainWater {

    public static void main(String[] args) {
        var trw = new TappingRainWater();
        System.out.println(trw.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int leftmax = 0;
        int rightmax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftmax) {
                    leftmax = height[left];
                } else {
                    ans += (leftmax - height[left]);
                }
                left++;
            } else {

                if (height[right] >= rightmax) {
                    rightmax = height[right];
                } else {
                    ans += (rightmax - height[right]);
                }
                right--;
            }
        }
        return ans;
    }
}
