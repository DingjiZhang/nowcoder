package Hot100Key;

import leetCode100.myList.ListNode;

public class reverseList206 {
    public ListNode reverseList(ListNode head) {
        // pre cur
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
