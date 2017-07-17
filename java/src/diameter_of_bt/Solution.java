package diameter_of_bt;
import nub.Nu.TreeNode;

public class Solution {
    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return max;
    }

    int diameter(TreeNode node) {
        if (node == null) return 0;
        int left = diameter(node.left);
        int right = diameter(node.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);

    }
}
