package Hot100Key;

import leetCode100.myList.ListNode;

public class sortList148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 一分为二
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        return mergeTwoLists(sortList(head), sortList(secondHead));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        p.next = p1 != null ? p1 : p2;
        return dummy.next;
    }
}
