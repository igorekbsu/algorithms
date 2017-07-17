package bst_to_greater_tree;
import java.util.Stack;
import nub.Nu.TreeNode;

public class Solution {
    public TreeNode convertBSTRecursive(TreeNode root) {
        visit(root, 0);
        return root;
    }

    int visit(TreeNode node, int val) {
        if (node == null) return val;
        int right = visit(node.right, val);
        int left = visit(node.left, node.val + right);
        node.val += right;
        return left;
    }

    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        int sum = 0;
        TreeNode node = root;
        while (node != null || !s.isEmpty()) {
            while (node != null) {
                s.push(node);
                node = node.right;
            }
            node = s.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }
}
