package leaf_similar_tree;
import java.util.Stack;
import nub.Nu.TreeNode;

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        s1.add(root1); s2.add(root2);
        while (!s1.isEmpty() && !s2.isEmpty())
            if (dfs(s1) != dfs(s2))
                return false;
        return s1.isEmpty() && s2.isEmpty();
    }

    int dfs(Stack<TreeNode> s) {
        while (true) {
            TreeNode node = s.pop();
            if (node.left != null)
                s.push(node.left);
            if (node.right != null)
                s.push(node.right);
            if (node.left == null && node.right == null)
                return node.val;
        }
    }
}
