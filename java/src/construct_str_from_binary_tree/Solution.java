package construct_str_from_binary_tree;
import nub.Nu.TreeNode;

public class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder r = new StringBuilder();
        tree2str(t, r);
        return r.toString();
    }

    void tree2str(TreeNode t, StringBuilder r) {
        if (t != null) {
            r.append(t.val);
            if (t.left != null || t.right != null) {
                r.append("(");
                tree2str(t.left, r);
                r.append(")");
                if (t.right != null) {
                    r.append("(");
                    tree2str(t.right, r);
                    r.append(")");
                }
            }
        }
    }
}
