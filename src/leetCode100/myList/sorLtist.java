package leetCode100.myList;

public class sorLtist {

    public ListNode sortList(ListNode head) {
        // 归并排序 先分割，再合并
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 处分割
        ListNode next = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(next);

        // 新链表存结果
        ListNode pre = new ListNode(0);
        ListNode ans = pre;
        while (left != null && right != null) {
            if (left.val < right.val) {
                pre.next = left;
                left = left.next;
            } else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        pre.next = left == null ? right : left;
        return ans.next;
    }
}
