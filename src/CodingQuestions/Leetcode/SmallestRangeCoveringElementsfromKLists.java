import java.util.List;
import java.util.PriorityQueue;

/**

632. Smallest Range Covering Elements from K Lists
Solved
Hard
Topics
Companies
You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

  **/
class Tracker
{
 int val; 
 int index;
 int column;
 public Tracker(int val, int index, int column)
 {
    this.val = val;
    this.index = index;
    this.column = column;
 }   
}

public class SmallestRangeCoveringElementsfromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
    PriorityQueue<Tracker>track = new PriorityQueue<>((a, b)-> a.val-b.val);
    int maxVal = Integer.MIN_VALUE;
    int n = nums.size();
    int startRange = 0;
    int endRange = Integer.MAX_VALUE;

    for(int i=0; i<n; i++)
    {
     int val = nums.get(i).get(0);   
     track.offer(new Tracker(val, i, 0)); // i am adding all list first value sitting at 0th column in nums
     maxVal = Math.max(maxVal, val);
    }   
    
    while(track.size()==n)
    {
      Tracker temp = track.poll();  
      if(maxVal-temp.val < endRange-startRange)
      {
        startRange = temp.val;
        endRange = maxVal;
      }
     
      if(nums.get(temp.index).size()>temp.column+1)
      {
        int nextVal = nums.get(temp.index).get(temp.column+1);
        track.offer(new Tracker(nextVal, temp.index,  temp.column+1));
        maxVal = Math.max(maxVal, nextVal);
      }
    }
   
     return new int[]{startRange, endRange};
    }
}
