import java.util.Stack;

/**
1541. Minimum Insertions to Balance a Parentheses String
Solved
Medium
Topics
Companies
Hint
Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:

Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.

For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
You can insert the characters '(' and ')' at any position of the string to balance it if needed.

Return the minimum number of insertions needed to make s balanced.
  **/
//without stack

public class MinimumInsertionstoBalanceaParenthesesString {
    public int minInsertions(String s) {
        int count=0;
        int open=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')'){
                if(i+1<s.length() && s.charAt(i+1)==')'){
                    if(open!=0)open--;
                    else count++;
                    i++;
                }else{
                    if(open!=0){
                        count++;
                        open--;
                    }else count+=2;
                }
            }else open++;
            
        }
        return open*2+count;
    }
}

//with stack

class MinimumInsertionstoBalanceaParenthesesString1 {
    public int minInsertions(String s) {
        Stack<Character> stack=new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }
            else{
                if(i+1<s.length()&& s.charAt(i+1)==')'){
                    i++;
                }
                else {
                    count++;
                }
                
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    count++;
                }
            }
        }
        count += 2*stack.size();
        return count;
    }
}
