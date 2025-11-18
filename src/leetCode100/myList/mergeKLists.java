package leetCode100.myList;

import java.util.PriorityQueue;

public class mergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        // 最小堆
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode head : lists) if (head != null) pq.offer(head);

        ListNode dummy = new ListNode(0), tail = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = node;
            if (node.next != null) pq.offer(node.next);
        }
        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        // 分治
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    // 把list[l..r]合并
    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l > r) return null;
        if (l == r) return lists[l];
        int m = (l + r) >> 1;
        ListNode left = merge(lists, l, m);
        ListNode right = merge(lists, m + 1, r);
        return mergeTwo(left, right);
    }

    // 二路合并
    private ListNode mergeTwo(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0), t = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                t.next = a;
                a = a.next;
            } else {
                t.next = b;
                b = b.next;
            }
            t = t.next;
        }
        t.next = a == null ? b : a;
        return dummy.next;
    }
}
