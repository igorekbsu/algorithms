package insert_into_bst;
import nub.Nu.TreeNode;

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null)
            return newNode;
        return insert(root, newNode);
    }

    TreeNode insert(TreeNode node, TreeNode newNode) {
        if (node == null)
            return newNode;
        if (newNode.val < node.val)
            node.left = insert(node.left, newNode);
        else node.right = insert(node.right, newNode);
        return node;
    }
}
