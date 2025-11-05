package MyList;

public class deleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = p1.next;

        if (head.val == val) {
            return head.next;
        }
        while (p2 != null) {
            if (p2.val == val) {
                p1.next = p2.next;
                return head;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
