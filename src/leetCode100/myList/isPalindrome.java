package leetCode100.myList;

import java.util.ArrayList;
import java.util.List;

public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        List<Integer> vals = new ArrayList<>();
        // 值到数组
        ListNode cur = head;
        while (cur != null) {
            vals.add(cur.val);
            cur = cur.next;
        }
        // 双指针判断
        int l = 0, r = vals.size() - 1;
        while (l < r) {
            if (!vals.get(l).equals(vals.get(r))) return false;
            l++;
            r--;
        }
        return true;
    }
}
