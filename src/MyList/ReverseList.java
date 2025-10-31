package MyList;

import java.util.Stack;

public class ReverseList {

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 两个节点承接第一和第二
        ListNode frontNode = head;
        ListNode removeNode = head.next;

        while (removeNode != null) {
            // 下一次的首
            ListNode tempNode = removeNode.next;
            // 反置
            removeNode.next = frontNode;
            // 两个节点右平移
            frontNode = removeNode;
            removeNode = tempNode;
        }

        head.next = null;
        return frontNode;
    }

    // 新建栈实现逆置，pop后新链表使用尾插法
    public ListNode ReverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        //从栈顶取出元素，第一个为head，尾插创建新链表
        ListNode removeNode = stack.pop();
        ListNode ans = removeNode;
        removeNode.next = null;
        while (!stack.isEmpty()) {
            ListNode newNode = stack.pop();
            newNode.next = null;
            removeNode.next = newNode;
            removeNode = newNode;
        }
        return ans;
    }
}
