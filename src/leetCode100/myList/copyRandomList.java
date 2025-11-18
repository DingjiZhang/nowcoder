package leetCode100.myList;

import java.util.HashMap;
import java.util.Map;

public class copyRandomList {

    public Node copyRandomList(Node head) {
        // 借助map映射
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.getOrDefault(head, null);
    }
}
