/**
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

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

**/

// solution 1
public class WaterContainer {
    public int maxArea(int[] height) {
        int start=0,area=0;
        int end= height.length-1;

        while(end>start){
            int min = Math.min(height[start],height[end]);
            area = Math.max(min*(end-start),area);
            while(end>start && height[start]<=min) {
                start++;
            }
            
            while(end>start && height[end]<=min) {
                end--;
            }
        }
        return area;
        
    }
}


//solution 2

class WaterContainer1 {
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
