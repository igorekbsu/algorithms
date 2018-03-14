package binary_tree_level_order_traversal;
import java.util.LinkedList;
import java.util.List;
import static nub.Nu.TreeNode;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> r = new LinkedList<>();
        if (root == null) return r;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new LinkedList<>();
            for (; size > 0; size--) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            r.add(0, level);
        }
        return r;
    }
}
