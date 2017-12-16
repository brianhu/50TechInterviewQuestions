package brian;

import java.util.Stack;

/**
 * Created by brian on 12/11/17.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int n2 = stack.pop(), n1 = stack.pop();
                    stack.push(n1 - n2);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    n2 = stack.pop(); n1 = stack.pop();
                    stack.push(n1 / n2);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
