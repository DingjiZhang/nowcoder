package MyList;

import java.util.HashMap;
import java.util.Map;

public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode node = pHead;
        while (node != null) {
            map.put(node, map.getOrDefault(node, 0) + 1);
            // 第二次出现的节点即为环入口（入度为2）
            if (map.get(node) == 2) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
}
