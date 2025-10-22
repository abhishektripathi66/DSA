package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Subset{
    public static void main(String[]args){
        int[]nums={1,2,3};
        System.out.println(subsets(nums));
    }
  static public List<List<Integer>> subsets(int[] nums) {
         Arrays.sort(nums);
        List<List<Integer>> outer=new ArrayList<>();
        List<Integer> internal=new ArrayList<>();

        int end=0;
        outer.add(internal);
        for(int i=0;i<nums.length;i++){
                    int start=0;
if(i>0&&nums[i-1]==nums[i]){
  start=end+1;  
}
end=outer.size()-1;
int n=outer.size();
for(int j=start;j<n;j++){
    internal=new ArrayList<>(outer.get(j));
    internal.add(nums[i]);
    outer.add(internal);
}

        }
        return outer;
    }
}