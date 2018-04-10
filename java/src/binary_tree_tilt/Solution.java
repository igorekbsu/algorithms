package binary_tree_tilt;
import nub.Nu.TreeNode;

public class Solution {
    int tilt;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        postOrder(root);
        return tilt;
    }

    int postOrder(TreeNode node) {
        if (node == null) return 0;
        int left = postOrder(node.left), right = postOrder(node.right);
        tilt += Math.abs(left - right);
        return node.val + right + left;
    }
}
