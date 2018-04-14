package two_sum_IV;
import java.util.HashSet;
import java.util.Set;
import static nub.Nu.TreeNode;

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> s = new HashSet<>();
        return bfs(root, k ,s);
    }

    boolean bfs(TreeNode node, int k, Set<Integer> s) {
        if(node == null)return false;
        if(s.contains(k - node.val))return true;
        s.add(node.val);
        return bfs(node.left, k, s) || bfs(node.right, k, s);
    }
}
