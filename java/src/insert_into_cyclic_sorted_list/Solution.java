package insert_into_cyclic_sorted_list;
public class Solution {
    public Node insert(Node head, int val) {
        if (head == null) {
            Node node = new Node(val, null);
            node.next = node;
            return node;
        }
        Node pre = head, next = head.next;
        while (true) {
            if (pre.val <= val && next.val >= val
                || next.val >= val && pre.val >= next.val
                || pre.val <= val && pre.val >= next.val) {
                pre.next = new Node(val, next);
                break;
            }
            pre = next;
            next = next.next;
        }
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
