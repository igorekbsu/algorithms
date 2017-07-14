package subtree_of_another_tree;
import static nub.Nu.TreeNode;

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    boolean equals(TreeNode s, TreeNode t) {
        if (s == null) return t == null;
        if (t == null || s.val != t.val) return false;
        return equals(s.left, t.left) && equals(s.right, t.right);
    }
}
