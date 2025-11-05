package nowCoder.MyList;

public class MergeListIncrease {

    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        // write code here
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }
        // 结果链表的头节点
        ListNode mergedHead = null;
        // 结果链表的尾节点
        ListNode mergedTail = null;

        if (pHead1.val < pHead2.val) {
            mergedHead = pHead1;
            pHead1 = pHead1.next;
        } else {
            mergedHead = pHead2;
            pHead2 = pHead2.next;
        }

        mergedTail = mergedHead;

        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val < pHead2.val) {
                mergedTail.next = pHead1;
                mergedTail = pHead1;
                pHead1 = pHead1.next;
            } else {
                mergedTail.next = pHead2;
                mergedTail = pHead2;
                pHead2 = pHead2.next;
            }
        }

        // 当有一个链表合并完毕，就将另一个剩下的链表全部尾插
        while (pHead1 != null) {
            mergedTail.next = pHead1;
            mergedTail = pHead1;
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            mergedTail.next = pHead2;
            mergedTail = pHead2;
            pHead2 = pHead2.next;
        }

        return mergedHead;
    }
}
