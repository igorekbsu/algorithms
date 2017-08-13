package find_leaves_of_binary_tree;
import java.util.ArrayList;
import java.util.List;
import nub.Nu;
import nub.Nu.TreeNode;

public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();
        if (root == null) return r;
        visit(root, r, 0);
        return r;
    }

    void visit(TreeNode root, List<List<Integer>> r, int level) {

    }
}
