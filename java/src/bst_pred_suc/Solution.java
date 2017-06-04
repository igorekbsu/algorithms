package bst_pred_suc;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return find(root, root, null, p);
    }

    TreeNode find(TreeNode node, TreeNode parent, TreeNode lastLeftParent, TreeNode p) {
        if (node.val == p.val) {
            if (node.right != null)
                return leftMost(node.right);
            else if (parent.left == node)
                return parent;
            else return lastLeftParent;
        } else if (p.val < node.val) {
            return find(node.left, node, node, p);
        } else {
            return find(node.right, node, lastLeftParent, p);
        }
    }

    TreeNode leftMost(TreeNode node) {
        if (node == null || node.left == null) return node;
        return leftMost(node.left);
    }

    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        if (root.val <= p.val) {
            return successor(root.right, p);
        } else {
            TreeNode left = successor(root.left, p);
            return (left != null) ? left : root;
        }
    }

    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}