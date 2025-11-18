package leetCode100.myList;

public class detectCycle {

    /*
     * 1. f 2步 slow 1步
     * 第一次相遇（a为head到入口前一个 b为环长度）
     * 步数：f = a + nb；f = s + nb
     * 整理：f=2nb; s=nb;
     * 所以让s再走a就是入口处
     *
     * 2.fast=head。同时走一步，f和s相遇时，s=a+nb即入口处
     *
     * */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;

        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            // 第一次相遇
            if (fast == slow) break;
        }
        fast = head;
        // 第二次相遇
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
