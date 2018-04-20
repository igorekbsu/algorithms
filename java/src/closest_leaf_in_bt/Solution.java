package closest_leaf_in_bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import nub.Nu.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        one.left = two;
        two.left = three;
        two.right = four;
        three.left = five;
        System.out.println(new Solution().findClosestLeaf(one, 1));
    }

    public int findClosestLeaf(TreeNode root, int k) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        dfs(g, root, null);
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        Set<Integer> used = new HashSet<>();
        used.add(k);
        while (!q.isEmpty()) {
            Integer u = q.poll();
            if (g.get(u).size() == 1 && u != root.val)
                return u;
            for (Integer v : g.get(u))
                if (used.add(v))
                    q.add(v);
        }
        return k;
    }

    void dfs(Map<Integer, List<Integer>> g, TreeNode node, TreeNode p) {
        if (node == null) return;
        g.putIfAbsent(node.val, new ArrayList<>(3));
        List<Integer> adj = g.get(node.val);
        if (p != null) {
            adj.add(p.val);
            g.get(p.val).add(node.val);
        }
        if (node.left != null) dfs(g, node.left, node);
        if (node.right != null) dfs(g, node.right, node);
    }
}
