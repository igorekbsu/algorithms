package flatten_mulilevel_doubly_linked_list;

class Solution {
    Node prev;

    public Node flatten(Node head) {
        Node node = head;
        while (node != null) {
            if (node.child != null) {
                Node next = node.next;
                node.child.prev = node;
                node.next = flatten(node.child);
                node.child = null;
                if (next != null) {
                    prev.next = next;
                    next.prev = prev;
                }
            }
            prev = node;
            node = node.next;
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
