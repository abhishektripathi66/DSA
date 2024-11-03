/**
796. Rotate String
Solved
Easy
Topics
Companies
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
  **/
class Solution {
    public boolean rotateString(String s, String goal) {
        
        int i=0;
        String a = s;
        while(i<s.length()){
            a = rotate(a);
            if(a.equals(goal)) return true;
            i++;
        }
        return false;

    }

    static String rotate(String str)
    {
            String ans = str.substring(str.length()-1) + str.substring(0, str.length()-1);
            return ans;
    }
}

//fast solution
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())
        return false;
        String str=s+s;
        if(str.contains(goal))
        return true;
        return false;
    }

}
