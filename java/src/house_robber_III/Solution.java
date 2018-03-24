package house_robber_III;
import static nub.Nu.TreeNode;

public class Solution {
    public int rob(TreeNode root) {
        int[] r = robHouses(root);
        return Math.max(r[0], r[1]);
    }

    int[] robHouses(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = robHouses(root.left);
        int[] right = robHouses(root.right);
        return new int[]{
            root.val + left[1] + right[1],
            Math.max(left[0], left[1]) + Math.max(right[0], right[1])
        };
    }
}
