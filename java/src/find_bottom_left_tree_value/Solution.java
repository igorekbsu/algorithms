package find_bottom_left_tree_value;
import java.util.LinkedList;
import java.util.Queue;
import static nub.Nu.TreeNode;

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root.right != null) q.add(root.right);
            if (root.left != null) q.add(root.left);
        }
        return root.val;
    }
}
