package range_sum_of_bst;
import nub.Nu.TreeNode;

public class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return dfs(root, L, R);
    }

    int dfs(TreeNode node, int L, int R) {
        if (node == null) return 0;
        int sum = 0;
        if (L <= node.val && node.val <= R)
            sum += node.val;
        if (L < node.val)
            sum += dfs(node.left, L, R);
        if (node.val < R)
            sum += dfs(node.right, L, R);
        return sum;
    }
}