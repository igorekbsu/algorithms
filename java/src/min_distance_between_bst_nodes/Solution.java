package min_distance_between_bst_nodes;
import nub.Nu.TreeNode;

public class Solution {
    int min = Integer.MAX_VALUE, prevValue;

    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return min;
    }

    void traverse(TreeNode node) {
        if (node != null) {
            traverse(node.left);
            min = Math.min(Math.abs(prevValue - node.val), min);
            prevValue = node.val;
            traverse(node.right);
        }
    }
}
