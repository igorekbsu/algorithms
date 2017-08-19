package delete_node_bst;
import nub.Nu.TreeNode;

public class Solution {
    public TreeNode deleteNode(TreeNode node, int key) {
        if (node == null)
            return null;
        if (key < node.val) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.val) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null)
                return node.left;
            TreeNode next = next(node.right);
            node.val = next.val;
            node.right = deleteNode(node.right, node.val);
        }
        return node;
    }

    TreeNode next(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }
}
