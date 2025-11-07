package nowCoder.myStack;

import java.util.Stack;

public class RelizQueueBy2Stack {
    Stack<Integer> stack1 = new Stack<Integer>(); // in
    Stack<Integer> stack2 = new Stack<Integer>(); // out

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) { // 只在out栈空时搬运，所有元素只会被搬一次
            // 将in栈全部搬到out栈
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
