package leetCode100.myList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class getIntersectionNode {

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // 尾部一定相同
        // 利用两个栈，找到尾部最后一个相同的即可
        if (headA == null || headB == null) return null;

        Deque<ListNode> s1 = new ArrayDeque<>();
        Deque<ListNode> s2 = new ArrayDeque<>();

        while (headA != null) {
            s1.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            s2.push(headB);
            headB = headB.next;
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
}
