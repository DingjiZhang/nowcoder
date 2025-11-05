package MyList;

// 删除重复的元素，使其只出现一次
public class DeleteDuplication2 {

    public ListNode DeleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode ans = pHead;
        // 找到第一个不重复的头
        while (ans.next != null && ans.next.val == ans.val) {
            ans = ans.next;
        }

        // 间隔为1的滑动窗口
        ListNode node1 = ans.next;
        ListNode node2 = node1 == null ? null : node1.next; // 1-1-1
        // 尾插法 如果滑动窗口内的两个节点值不相等，node1即为第一个不重复的节点。相等，则一起后移
        ListNode lastNode = ans;
        while (node2 != null) { // 注意最后要插入最后一个节点
            if (node1 != node2) {
                lastNode.next = node1;
                lastNode = node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        // 插入原链表最后一个节点
        lastNode.next = node1;
        return ans;
    }
}
