package nowCoder.MyList;


import java.util.HashMap;
import java.util.Map;

public class Clone {
    public RandomListNode Clone(RandomListNode pHead) {
        // 思路：先new出单个的所有node，再把他们链接起来（通过map组织新元素）
        // 旧-新 node的映射
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode moveNode = pHead;
        while (moveNode != null) {
            RandomListNode node = new RandomListNode(moveNode.label);
            map.put(moveNode, node);
            moveNode = moveNode.next;
        }

        // 重新遍历map，通过map获取map内的新元素，而非直接赋值——指向旧表的元素地址
        moveNode = pHead;
        while (moveNode != null) {
            RandomListNode node = map.get(moveNode);
            node.next = map.get(moveNode.next);
            node.random = map.get(moveNode.random);
            moveNode = moveNode.next;
        }
        return map.getOrDefault(pHead, null);
    }

    public RandomListNode Clone2(RandomListNode pHead) {
        // 注意空！！！
        if (pHead == null) {
            return null;
        }
        // 1. 创建新链表节点插入到原链表每个节点的后一个位置
        RandomListNode moveNode = pHead;
        while (moveNode != null) {
            RandomListNode temp = moveNode.next; // 保存下一个节点
            RandomListNode node = new RandomListNode(moveNode.label);
            moveNode.next = node; // 新节点插入到源节点后面
            node.next = temp;
            moveNode = temp; // 移动到下一个源节点
        }
        // 2. 创建random节点指向
        moveNode = pHead;
        while (moveNode != null) {
            // 原链表random节点的下一个节点即为新链表的random节点
            moveNode.next.random = moveNode.random == null ? null : moveNode.random.next; //
            moveNode = moveNode.next.next; // 只遍历原链表
        }
        // 3. 链表分割：奇数位 为 原链表，偶数位 为 新链表
        moveNode = pHead;
        RandomListNode cloneHead = pHead.next;
        while (moveNode != null) {
            RandomListNode node = moveNode.next;
            moveNode.next = node.next; // 原链表结构关系维护
            node.next = node.next == null ? null : node.next.next; // 新链表分割 处理最后一个node.next后是null
            moveNode = moveNode.next;
        }
        return cloneHead;
    }
}
