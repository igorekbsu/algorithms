package second_min_node_in_binary_tree;
import static nub.Nu.TreeNode;

public class Solution {
    int min;
    long secondMin = Long.MAX_VALUE;

    public void dfs(TreeNode root) {
        if (root != null)
            if (min < root.val && root.val < secondMin)
                secondMin = root.val;
            else if (min == root.val) {
                dfs(root.left);
                dfs(root.right);
            }
    }

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        dfs(root);
        return secondMin < Long.MAX_VALUE ? (int) secondMin : -1;
    }
}
