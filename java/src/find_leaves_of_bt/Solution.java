package find_leaves_of_bt;
import java.util.LinkedList;
import java.util.List;
import static nub.Nu.TreeNode;

public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> r = new LinkedList<>();
        height(root, r);
        return r;
    }

    int height(TreeNode node, List<List<Integer>> r) {
        if (node == null) return -1;
        int h = 1 + Math.max(height(node.left, r), height(node.right, r));
        if (h == r.size())
            r.add(new LinkedList<>());
        r.get(h).add(node.val);
        return h;
    }
}
