package lru;
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.useCache();
    }

    private void useCache() {
        LRUCache cache = new LRUCache(2 /* capacity */);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

    public class LRUCache {
        final int capacity;
        final Map<Integer, Node> map = new HashMap<>();
        Node head = new Node(0, 0), tail = new Node(0, 0);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1;
            rmNode(node);
            insertNode(node);
            return node.val;
        }

        void rmNode(Node n) {
            Node prev = n.prev, next = n.next;
            prev.next = next;
            next.prev = prev;
            map.remove(n.key);
        }

        void insertNode(Node n) {
            Node prev = tail.prev;
            tail.prev = n;
            n.next = tail;
            n.prev = prev;
            prev.next = n;
            map.put(n.key, n);
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null) {
                if (map.size() == capacity)
                    rmNode(head.next);
                insertNode(new Node(key, value));
            } else {
                rmNode(node);
                node.val = value;
                insertNode(node);
            }
        }

        class Node {
            int key, val;
            Node prev, next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}