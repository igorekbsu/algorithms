package vertical_order;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();
        if (root == null) return r;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        Queue<Integer> cols = new ArrayDeque<>();
        q.add(root);
        cols.add(0);
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            Integer col = cols.poll();
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);
            if (node.left != null) {
                q.add(node.left);
                cols.add(col - 1);
            }
            if (node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
            }
            min = Math.min(col, min);
            max = Math.max(col, max);
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