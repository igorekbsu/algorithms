package recover_bst;
import nub.Nu.TreeNode;

public class Solution {
    TreeNode first, second, prevElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (first == null && prevElement.val >= root.val)
            first = prevElement;
        if (first != null && prevElement.val >= root.val)
            second = root;
        prevElement = root;
        traverse(root.right);
    }
}

