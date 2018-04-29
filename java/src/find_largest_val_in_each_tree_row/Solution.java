package find_largest_val_in_each_tree_row;
import java.util.ArrayList;
import java.util.List;
import nub.Nu.TreeNode;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        dfs(root, r, 0);
        return r;
    }

    void dfs(TreeNode node, List<Integer> r, int d) {
        if (node == null) return;
        if (r.size() == d)
            r.add(node.val);
        else if (node.val > r.get(d))
            r.set(d, node.val);
        dfs(node.left, r, d + 1);
        dfs(node.right, r, d + 1);
    }
}
