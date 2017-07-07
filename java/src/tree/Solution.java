package tree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    int max;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        lc(root, root.val, 0);
        return max;
    }

    void lc(TreeNode node, int target, int count) {
        if (node == null) return;
        if (node.val == target) {
            count++;
            max = Math.max(max, count);
        } else
            count = 1;
        lc(node.left, node.val + 1, count);
        lc(node.right, node.val + 1, count);
    }

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

    //returns all root to leaf paths 5->3->2
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        if (root == null) return paths;
        btPaths(root, "", paths);
        return paths;
    }

    void btPaths(TreeNode node, String pre, List<String> paths) {
        if (node.left == null && node.right == null) paths.add(String.valueOf(pre + node.val));
        if (node.left != null) btPaths(node.left, pre + node.val + "->", paths);
        if (node.right != null) btPaths(node.right, pre + node.val + "->", paths);
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> r = new LinkedList<>();
        preorder(root, r);
        return r;
    }

    void preorder(TreeNode node, List<Integer> r) {
        if (node != null) {
            r.add(node.val);
            preorder(node.left, r);
            preorder(node.right, r);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> r = new LinkedList<>();
        if (root == null) return r;
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            r.add(node.val);
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
        }
        return r;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> r = new LinkedList<>();
        if (root == null) return r;
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        while (node != null || !s.isEmpty()) {
            while (node != null) {
                s.add(node);
                node = node.left;
            }
            node = s.pop();
            r.add(node.val);
            node = node.right;
        }
        return r;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}