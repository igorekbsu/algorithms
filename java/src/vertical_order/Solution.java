package vertical_order;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();
        if (root == null) return r;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        Queue<Integer> levels = new ArrayDeque<>();
        nodes.add(root);
        levels.add(0);
        int min = 0, max = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            Integer level = levels.remove();
            map.putIfAbsent(level, new ArrayList<>());
            map.get(level).add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
                levels.add(level - 1);
                min = Math.min(level - 1, min);
            }
            if (node.right != null) {
                nodes.add(node.right);
                levels.add(level + 1);
                max = Math.max(level + 1, max);
            }
        }
        for (int i = min; i <= max; i++)
            r.add(map.get(i));
        return r;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}