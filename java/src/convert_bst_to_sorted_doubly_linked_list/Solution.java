package convert_bst_to_sorted_doubly_linked_list;
public class Solution {
    Node prev;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dummy = new Node(0, null, null);
        prev = dummy;
        traverse(root);
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    void traverse(Node node) {
        if (node == null) return;
        traverse(node.left);
        prev.right = node;
        node.left = prev;
        prev = node;
        traverse(node.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
