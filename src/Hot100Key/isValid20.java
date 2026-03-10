package Hot100Key;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class isValid20 {
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }

        return stack.isEmpty();
    }
}
