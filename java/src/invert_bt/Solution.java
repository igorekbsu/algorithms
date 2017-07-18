package invert_bt;
import nub.Nu.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode right = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = right;
        return root;
    }
}
