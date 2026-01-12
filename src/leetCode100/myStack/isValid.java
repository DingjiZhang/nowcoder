package leetCode100.myStack;

import java.util.Stack;

public class isValid {

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) return false;
        if (s.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
