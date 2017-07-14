package avr_of_levels_bt;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import static nub.Nu.TreeNode;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> r = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            double avr = 0, size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                avr += node.val;
            }
            r.add(avr / size);
        }
        return r;
    }
}
