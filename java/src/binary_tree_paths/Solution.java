package binary_tree_paths;
import java.util.LinkedList;
import java.util.List;
import nub.Nu.TreeNode;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        paths(root, "", paths);
        return paths;
    }

    void paths(TreeNode node, String path, List<String> paths) {
        if (node == null) return;
        path += node.val;
        if (node.right == null && node.left == null)
            paths.add(path);
        if (node.right != null)
            paths(node.right, path + "->", paths);
        if (node.left != null)
            paths(node.left, path + "->", paths);
    }
}
