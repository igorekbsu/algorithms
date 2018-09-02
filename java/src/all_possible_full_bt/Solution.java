package all_possible_full_bt;
import java.util.LinkedList;
import java.util.List;
import nub.Nu.TreeNode;

public class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> trees = new LinkedList<>();
        if (N == 1) {
            trees.add(new TreeNode(0));
            return trees;
        }
        N = N - 1;
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> leftNodes = allPossibleFBT(i);
            List<TreeNode> rightNodes = allPossibleFBT(N - i);
            for (TreeNode left : leftNodes)
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
        }
        return trees;
    }
}
