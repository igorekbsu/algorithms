package max_depth_of_binary_tree;
import java.util.LinkedList;
import java.util.Queue;
import static nub.Nu.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null)
            q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            for (; size > 0; size--) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return depth;
    }
}
