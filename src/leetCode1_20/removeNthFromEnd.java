package leetCode1_20;

import leetCode100.myList.ListNode;

public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // delete second.next
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
