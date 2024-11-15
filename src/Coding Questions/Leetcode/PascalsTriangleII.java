import java.util.ArrayList;
import java.util.List;

/**
119. Pascal's Triangle II
Solved
Easy
Topics
Companies
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
**/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        if(rowIndex==0){  return l;}
        l.add(1);
        if(rowIndex==1){  return l;}
        for(int i=2;i<=rowIndex;i++){
            List<Integer> l1 = new ArrayList<>();
            l1.add(1);
            for(int j=1;j<i;j++){
                l1.add((l.get(j-1)+l.get(j)));
            }
            l1.add(1);
            l=l1;
        }

        return l;
    }
}

// best solution
