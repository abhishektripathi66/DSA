public class FindthePowerofKSizeSubarraysI {
    

    public int[] resultsArray(int[] nums, int k) 
    {
        int n = nums.length;
        int subArrCount = n-k+1;
        int[] subArrPower = new int[n-k+1];
        int inconsecutiveElementCount = 0;
        for(int i=1; i<k; i++)
        {
            if(nums[i] != nums[i-1]+1)
            {
                inconsecutiveElementCount++;
            }
        }
        int start =0, end = k-1;
        while(end<n)
        {
            subArrPower[start] = inconsecutiveElementCount == 0 ? nums[end] : -1;
            if(start<n-1 && nums[start] != nums[start+1]-1)
            {
                inconsecutiveElementCount--;
            }
            start++;
            if(end<n-1 && nums[end+1] != nums[end]+1)
            {
                inconsecutiveElementCount++;
            }
            end++;
        }
        return subArrPower;
        
    }
    
}
