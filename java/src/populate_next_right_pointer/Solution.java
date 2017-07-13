package populate_next_right_pointer;
public class Solution {
    public void connectPerfect(TreeLinkNode root) {
        TreeLinkNode left = root;
        if (root == null) return;
        while (left.left != null) {
            TreeLinkNode node = left;
            while (node != null) {
                node.left.next = node.right;
                if (node.next != null)
                    node.right.next = node.next.left;
                node = node.next;
            }
            left = left.left;
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode current = root, head = null, prev = null;
        while (current != null) {
            while (current != null) {
                if (current.left != null) {
                    if (prev != null)
                        prev.next = current.left;
                    else head = current.left;
                    prev = current.left;
                }
                if (current.right != null) {
                    if (prev != null)
                        prev.next = current.right;
                    else head = current.right;
                    prev = current.right;
                }
                current = current.next;
            }
            current = head;
            prev = head = null;
        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) { val = x; }
    }
}