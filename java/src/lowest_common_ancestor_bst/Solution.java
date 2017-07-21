package lowest_common_ancestor_bst;
import nub.Nu.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val)
            return lowestCommonAncestor(root, q, p);
        while (root.val != p.val || root.val != q.val) {
            if (root.val > p.val && root.val < q.val)
                return root;
            if (root.val <= p.val)
                root = root.right;
            else root = root.left;
        }
        return root;
    }
}
