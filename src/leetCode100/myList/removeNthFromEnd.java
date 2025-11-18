package leetCode100.myList;

public class removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针 间隔n，f到结尾null时，s到倒数第n个
        // 便于删除，s在被删除前一个好，刚好头节点前面再加一个预指针
        if (head == null) return null;

        ListNode pre = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = pre;

        // 间隔n
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 一起移动到f为null
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }
}
