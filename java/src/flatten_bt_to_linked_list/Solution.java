package flatten_bt_to_linked_list;
import nub.Nu.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left, right = root.right;
        root.left = null;
        flatten(left);
        flatten(right);
        root.right = left;
        TreeNode node = root;
        while (node.right != null)
            node = node.right;
        node.right = right;
    }
}
