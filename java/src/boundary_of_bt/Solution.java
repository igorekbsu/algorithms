package boundary_of_bt;
import java.util.LinkedList;
import java.util.List;
import nub.Nu.TreeNode;

public class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> r = new LinkedList<>();
        if (root == null) return r;
        r.add(root.val);
        TreeNode node = root.left;
        if (node != null)
            while (node.left != null || node.right != null) {
                r.add(node.val);
                node = node.left != null ? node.left : node.right;
            }
        if (root.left != null || root.right != null)
            leaves(root, r);
        right(root.right, r);
        return r;
    }

    void right(TreeNode node, List<Integer> r) {
        if (node == null || node.right == null && node.left == null) return;
        TreeNode next = node.right != null ? node.right : node.left;
        right(next, r);
        r.add(node.val);
    }

    void leaves(TreeNode root, List<Integer> r) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            r.add(root.val);
        else {
            leaves(root.left, r);
            leaves(root.right, r);
        }
    }
}
