package brian;

import java.util.Stack;

/**
 * Created by brian on 12/12/17.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')'); break;
                case '[':
                    stack.push(']'); break;
                case '{':
                    stack.push('}'); break;
                default:
                    // "()]"
                    if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
    }
}
