package increasing_order_search_tree;
import java.util.LinkedList;
import nub.Nu.TreeNode;

public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        inorder(root, q);
        return tree(q);
    }

    TreeNode tree(LinkedList<TreeNode> q) {
        if(q.isEmpty())
            return null;
        TreeNode node = q.pollFirst();
        node.left = null;
        node.right = tree(q);
        return node;
    }

    void inorder(TreeNode node, LinkedList<TreeNode> q) {
        if (node != null) {
            inorder(node.left, q);
            q.offer(node);
            inorder(node.right, q);
        }
    }
}
