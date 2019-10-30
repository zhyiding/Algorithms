package _13_data_structure_designing;

import java.util.HashMap;
import java.util.Map;

// #146
public class LRUCache {

    private class DLNode {
        DLNode next = null;
        DLNode prev = null;
        int key = 0;
        int val = 0;

        public DLNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private DLNode head = null;
    private DLNode tail = null;
    private Map<Integer, DLNode> hm = null;
    private int capacity = 0;

    public LRUCache(int capacity) {
        head = new DLNode(0, 0);
        tail = new DLNode(0, 0);
        head.next = tail;
        tail.prev = head;
        hm = new HashMap<>();
        this.capacity = capacity;
    }

    private void addToFront(DLNode node) {
        DLNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    private void remove(DLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLNode pop() {
        DLNode node = tail.prev;
        this.remove(node);
        return node;

    }

    private void moveToFront(DLNode node) {
        this.remove(node);
        this.addToFront(node);
    }

    public int get(int key) {
        if (!hm.containsKey(key)) {
            return -1;
        }
        DLNode node = hm.get(key);
        this.moveToFront(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            DLNode node = hm.get(key);
            node.val = value;
            this.moveToFront(node);
        } else {
            if (hm.size() >= capacity) {
                DLNode oldNode = this.pop();
                hm.remove(oldNode.key);
            }
            DLNode newNode = new DLNode(key, value);
            this.addToFront(newNode);
            hm.put(key, newNode);
        }
    }
}
