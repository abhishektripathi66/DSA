package Leetcode;
/*
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 * 
 */
public class ContainerMostWater {
    
    public static void main(String[] args) {
        var cmw = new ContainerMostWater();
        System.out.println(cmw.maxArea(new int[]{1,8,6,2,5,4,8,3,7})); ;
        System.out.println(cmw.maxAremyMethod(new int[]{1,8,6,2,5,4,8,3,7})); ;
    }

    public int maxAremyMethod(int[] height) {
        int area = Integer.MIN_VALUE;
        
        for(int i=0;i<height.length;i++){
            for(int j=i;j<height.length;j++){
              int  areas = (j-i)*(Math.min(height[i],height[j]));
                if(areas>area) { area=areas;}
            }
        }
        return area;
    }

    public int maxArea(int[] height) {
        int size = height.length;
        if(size == 1){return 0;}
        if(size == 2){return Math.min(height[0],height[1]) ;}
        
        int left = 0;
        int right = size-1;
        int max_area = 0;
        
        while(left != right){
            if(height[left] < height[right]){
                max_area = Math.max(max_area, height[left]*(right-left));
                left++;
            }
             else{
                 max_area = Math.max(max_area, height[right]*(right-left));
                 right--;
             }            
        }
       return max_area;
        
    }
}
