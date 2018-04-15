package bt_right_side_view;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import nub.Nu.TreeNode;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> r = new LinkedList<>();
        if (root == null) return r;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            r.add(q.peek().val);
            for (int size = q.size(); size > 0; size--) {
                TreeNode node = q.poll();
                if (node.right != null)
                    q.add(node.right);
                if (node.left != null)
                    q.add(node.left);
            }
        }
        return r;
    }
}
