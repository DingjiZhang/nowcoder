package nowCoder.MyList;

import java.util.Stack;

public class FindKthToTail {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // 双指针法：设置两个移动节点，他们的间隔是k。当后面的节点到尾部后null，前一节点就是倒数第k
        ListNode moveNode = pHead;
        // 间隔k
        while (k != 0) {
            if (moveNode == null) {
                return null;
            }
            moveNode = moveNode.next;
            k--;
        }
        //双指针一起遍历链表，直至后指针到尾后null
        while (moveNode != null) {
            moveNode = moveNode.next;
            pHead = pHead.next;
        }
        return pHead;
    }

    // 方法2 递归
    private ListNode ans;
    private int num2tail = 0;

    private void dfs(ListNode node, int k) {
        if (node == null) return; // 这里要注意 如果用非空逻辑，会多一层null对num的增加
        dfs(node.next, k);

        // 判断当前层是倒数第几层
        num2tail++;
        if (num2tail == k) {
            ans = node;
            return;
        }
    }

    public ListNode FindKthToTail2(ListNode pHead, int k) {
        ans = null;
        num2tail = 0;
        if (pHead == null) {
            return null;
        }
        dfs(pHead, k);
        return ans;
    }

    //方法3 栈
    public ListNode FindKthToTail3(ListNode pHead, int k) {
        if (pHead == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        while (pHead != null) {
            stack.push(pHead);
            pHead = pHead.next;
        }

        ListNode ans = null;
        while (k > 0) {
            if (stack.isEmpty()) { //注意k对栈的越界
                ans = null;
                break;
            }
            ans = stack.pop();
            k--;
        }
        return ans;
    }
}
