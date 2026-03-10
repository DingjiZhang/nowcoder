package Hot100Key;

import java.util.HashMap;

public class LRUCache146 {
    private class Node {
        int key, val;
        Node prev;
        Node next;

        private Node() {
        }

        private Node(int _key, int _val) {
            key = _key;
            val = _val;
        }
    }

    // 双向链表
    private class myList {
        Node head = new Node();
        Node tail = new Node();

        private myList() {
            head.next = tail;
            tail.prev = head;
        }

        private void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void remove(Node node) {
            Node nodePrev = node.prev;
            Node nodeNext = node.next;
            nodePrev.next = nodeNext;
            nodeNext.prev = nodePrev;
        }

        private Node removeLast() {
            Node res = tail.prev;
            remove(res);
            return res;
        }
    }

    public int capacity;
    public HashMap<Integer, Node> map;
    public myList myList;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        myList = new myList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        myList.remove(node); // 删除
        myList.addFirst(node); // 添加到表头
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            myList.remove(node);
            myList.addFirst(node);
        } else {
            if (map.size() == capacity) {
                Node last = myList.removeLast();
                map.remove(last.key);
            }
            Node node = new Node(key, value);
            myList.addFirst(node);
            map.put(key, node);
        }
    }
}
