package closest_bst_value_II;
import java.util.LinkedList;
import java.util.List;
import nub.Nu.TreeNode;

public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> r = new LinkedList<>();
        collect(root, target, k, r);
        return r;
    }

    void collect(TreeNode root, double target, int k, LinkedList<Integer> r) {
        if (root == null) return;
        collect(root.left, target, k, r);
        if (r.size() == k) {
            if (Math.abs(target - root.val) < Math.abs(target - r.peekFirst()))
                r.removeFirst();
            else return;
        }
        r.add(root.val);
        collect(root.right, target, k, r);
    }
}
