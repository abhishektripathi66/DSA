/*
679. 24 Game
Solved
Hard
Topics
premium lock icon
Companies
You are given an integer array cards of length 4. You have four cards, each containing a number in the range [1, 9]. You should arrange the numbers on these cards in a mathematical expression using the operators ['+', '-', '*', '/'] and the parentheses '(' and ')' to get the value 24.

You are restricted with the following rules:

The division operator '/' represents real division, not integer division.
For example, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12.
Every operation done is between two numbers. In particular, we cannot use '-' as a unary operator.
For example, if cards = [1, 1, 1, 1], the expression "-1 - 1 - 1 - 1" is not allowed.
You cannot concatenate numbers together
For example, if cards = [1, 2, 1, 2], the expression "12 + 12" is not valid.
Return true if you can get such expression that evaluates to 24, and false otherwise.

 

Example 1:

Input: cards = [4,1,8,7]
Output: true
Explanation: (8-4) * (7-1) = 24
Example 2:

Input: cards = [1,2,1,2]
Output: false
 

Constraints:

cards.length == 4
1 <= cards[i] <= 9
*/
class Solution {
    private List<Double> allOperations(double a, double b){
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        res.add(a / b);
        res.add(b / a);
        return res;
    }

    private boolean dfs(List<Double> list){
        if(list.size() == 1)
            return Math.abs(list.get(0) - 24) < 0.0001;
        
        //list.size() >= 2
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                //all operations between i and j: i + j, i - j, j - i, i * j, i / j, j / i
                List<Double> newList = new ArrayList<>();
                for(int k = 0; k < list.size(); k++){
                    if(k != i && k != j)
                        newList.add(list.get(k));
                }
                List<Double> getNext = allOperations(list.get(i), list.get(j));
                for(double k : getNext){
                    newList.add(k);
                    if(dfs(newList))
                        return true;
                    
                    newList.remove(newList.size() - 1);
                }
            }
        }
        return false;
    }

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for(int i : cards)
            list.add((double)i);
        
        return dfs(list);
    }
}
