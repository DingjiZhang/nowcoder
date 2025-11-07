package nowCoder.myStack;

import java.util.Stack;

public class IsPopOrder {

    // 借助一个栈来模拟，栈顶不是当前要弹的就压栈，栈顶是当前要弹的就弹出
    public boolean IsPopOrder(int[] pushV, int[] popV) {
        if (pushV == null || popV == null || pushV.length != popV.length) return false;
        int tot = pushV.length;
        Stack<Integer> st = new Stack<>();
        int i = 0, j = 0;

        while (j < tot) {
            // 栈顶不是当前要弹的就压栈
            while (i < tot && (st.isEmpty() || st.peek() != popV[j])) {
                st.push(pushV[i++]);
            }
            // 此时要么栈顶等于popV[j] 要么push用完
            if (!st.isEmpty() && st.peek() == popV[j]) {
                st.pop();
                j++;
            } else return false;
        }
        return true;

    }
}
