package leetCode100.myList;

public class swapPairs {

    public ListNode swapPairs(ListNode head) {
        // 1 2 3个节点，1从头开始
        // 交换12，3迭代后续
        // 2 -> 1 -> 3, 2为新头
        if (head == null || head.next == null) return head;
        ListNode one = head;
        ListNode two = one.next;
        ListNode three = two.next;

        two.next = one;
        one.next = swapPairs(three);

        return two;
    }

}
