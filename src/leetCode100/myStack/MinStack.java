package leetCode100.myStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    private Deque<Integer> data;
    private Deque<Integer> mins;

    public MinStack() {
        data = new ArrayDeque<>();
        mins = new ArrayDeque<>();
    }

    public void push(int val) {
        data.push(val);
        if (mins.isEmpty()) mins.push(val);
        else mins.push(Math.min(mins.peek(), val));
    }

    public void pop() {
        data.pop();
        mins.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
