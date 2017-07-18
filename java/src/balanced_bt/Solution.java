package balanced_bt;
import nub.Nu.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    int height(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(node.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(rightHeight - leftHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
