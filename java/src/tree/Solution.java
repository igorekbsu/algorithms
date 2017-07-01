package tree;
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}