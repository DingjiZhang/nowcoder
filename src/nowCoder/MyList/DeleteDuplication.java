package nowCoder.MyList;

// 删除所有重复的元素
public class DeleteDuplication {
    private ListNode getFirstDifferentNode(ListNode x) {
        int tempV = x.val;
        while (x != null && x.val == tempV) {
            // 后移，直至不是重复节点
            x = x.next;
        }
        return x;
    }

    public ListNode DeleteDuplication(ListNode pHead) {
        ListNode ans = pHead;
        // 确定最终链表头结点
        while (ans != null) {
            if (ans.next != null && ans.val == ans.next.val) {
                // 当前ans指向的节点是重复节点
                ans = getFirstDifferentNode(ans);
            } else {
                // 当前ans就是最终链表的头结点
                break;
            }
        }
        if (ans == null) {
            return null;
        }

        // 从ans遍历，判断每一个节点是否为重复节点
        // 尾插法
        ListNode lastNode = ans;
        ListNode moveNode = lastNode.next;
        while (moveNode != null) {
            if (moveNode.next != null && moveNode.val == moveNode.next.val) {
                // 重复节点
                moveNode = getFirstDifferentNode(moveNode);
            } else {
                lastNode.next = moveNode;
                lastNode = moveNode;
                moveNode = moveNode.next;
            }
        }
        // 1-2-2-3-3 -> 4-4
        // 将尾巴置为null
        lastNode.next = null;
        return ans;
    }
}
