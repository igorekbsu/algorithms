package largest_bst_subtree;
import nub.Nu.TreeNode;

public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        if (valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            return countNodes(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    boolean valid(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.val >= max || node.val <= min) return false;
        return valid(node.left, min, node.val) && valid(node.right, node.val, max);
    }

    int countNodes(TreeNode node) {
        return node == null ? 0 : 1 + countNodes(node.left) + countNodes(node.right);
    }
}
