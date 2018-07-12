package closest_bst_value;
import nub.Nu.TreeNode;

public class Solution {
    public int closestValue(TreeNode n, double t) {
        int closest = n.val;
        while (n != null) {
            if (Math.abs(t - n.val) < Math.abs(t - closest))
                closest = n.val;
            n = t < n.val ? n.left : n.right;
        }
        return closest;
    }
}
