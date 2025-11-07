package nowCoder.myStack;

import java.util.Stack;

public class RelizMinStack {
    /*
     * 维护双栈
     *  data：正常入栈元素
     *  min ：和 data 同步压栈“到当前为止的最小值元素”
     *      入栈时把  min（当前data，min.peek）压入
     *      出栈时两个一起弹
     *
     * */
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> mins = new Stack<>();

    public void push(int node) {
        data.push(node);
        if (mins.isEmpty()) mins.push(node);
        else mins.push(Math.min(node, mins.peek()));
    }

    public void pop() {
        data.pop();
        mins.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return mins.peek();
    }
}
