package codingquestions.leetcode;

import java.util.Stack;

/**
 * 1106. Parsing A Boolean Expression
 * Solved
 * Hard
 * Topics
 * Companies
 * Hint
 * A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:
 * <p>
 * 't' that evaluates to true.
 * 'f' that evaluates to false.
 * '!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
 * '&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
 * '|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
 * Given a string expression that represents a boolean expression, return the evaluation of that expression.
 * <p>
 * It is guaranteed that the given expression is valid and follows the given rules.
 **/
public class ParsingABooleanExpression {

    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for (char currChar : expression.toCharArray()) {
            if (currChar == ',' || currChar == '(') continue;
            if (
                    currChar == 't' ||
                            currChar == 'f' ||
                            currChar == '!' ||
                            currChar == '&' ||
                            currChar == '|'
            ) {
                st.push(currChar);
            } else if (currChar == ')') {
                boolean hasTrue = false, hasFalse = false;

                while (
                        st.peek() != '!' && st.peek() != '&' && st.peek() != '|'
                ) {
                    char topValue = st.pop();
                    if (topValue == 't') hasTrue = true;
                    if (topValue == 'f') hasFalse = true;
                }

                char op = st.pop();
                if (op == '!') {
                    st.push(hasTrue ? 'f' : 't');
                } else if (op == '&') {
                    st.push(hasFalse ? 'f' : 't');
                } else {
                    st.push(hasTrue ? 't' : 'f');
                }
            }
        }
        return st.peek() == 't';
    }
}
