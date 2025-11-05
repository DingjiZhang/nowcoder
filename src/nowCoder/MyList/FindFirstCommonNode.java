package nowCoder.MyList;

import java.util.Stack;

public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 两个链表的尾部起始一定相同
        // 利用栈从尾部开始比较，找到最后一个相同的栈顶值即可
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        while (pHead1 != null) {
            s1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            s2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode ans = null;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.peek().val == s2.peek().val) {
                ans = s1.pop();
                s2.pop();
            } else {
                break;
            }
        }
        return ans;
    }

    // 方法二：计算两个链表的长度，长的先走多出来的步数，然后一起走，找到第一个相同节点
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }

        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; ++i) {
                pHead1 = pHead1.next;
            }
        } else if (len2 > len1) {
            for (int i = 0; i < len2 - len1; ++i) {
                pHead2 = pHead2.next;
            }
        }

        ListNode ans = null;
        while (pHead1 != null) {
            if (pHead1.val == pHead2.val) {
                ans = pHead1;
                break;
            } else {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return ans;
    }

}
