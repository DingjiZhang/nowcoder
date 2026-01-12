package leetCode200;


import leetCode100.myList.ListNode;

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 头指针前加预指针：1.保留原头 2.便于返回
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0; // 进位位
        // 遍历
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum %= 10;

            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // 增加最后的进位
        if (carry == 1) cur.next = new ListNode(1);
        return pre.next;
    }
}
