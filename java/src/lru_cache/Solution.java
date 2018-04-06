package lru_cache;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    class LRUCache {
        Map<Integer, Node> m = new HashMap<>();
        final int capacity;
        Node tail = new Node(0), head = new Node(0);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            tail.next = head;
            head.prev = tail;
        }

        public int get(int key) {
            Node node = m.get(key);
            if (node == null) return -1;
            rm(node);
            insert(node);
            return node.val;
        }

        void insert(Node node) {
            Node prev = head.prev;
            prev.next = node;
            node.next = head;
            node.prev = prev;
            head.prev = node;
            m.put(node.key, node);
        }

        void rm(Node node) {
            Node next = node.next, prev = node.prev;
            prev.next = next;
            next.prev = prev;
            m.remove(node.key);
        }

        public void put(int key, int value) {
            Node node = m.get(key);
            if (node == null) {
                node = new Node(key);
                node.val = value;
                if (capacity == m.size())
                    rm(tail.next);
                insert(node);
            } else {    
                rm(node);
                node.val = value;
                insert(node);
            }
        }

        class Node {
            int key, val;
            Node prev, next;

            Node(int key) { this.key = key;}
        }
    }
}
