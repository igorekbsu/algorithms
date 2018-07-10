package smallest_subtree_with_all_the_deepest_nodes;
import nub.Nu.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(2);one.right = new TreeNode(3);
        one.left.left = new TreeNode(4);
        one.right.left = new TreeNode(6);
        one.right.right = new TreeNode(5);
        System.out.println(new Solution().subtreeWithAllDeepest(one).val);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return search(root).node;
    }

    Pair search(TreeNode root) {
        if (root == null) return new Pair(0, null);
        Pair L = search(root.left), R = search(root.right);
        if (L.depth < R.depth)
            return new Pair(R.depth + 1, R.node);
        else if (L.depth > R.depth)
            return new Pair(L.depth + 1, L.node);
        return new Pair(L.depth + 1, root);
    }

    class Pair {
        int depth;
        TreeNode node;

        Pair(int depth, TreeNode node) { this.depth = depth; this.node = node;}
    }
}
