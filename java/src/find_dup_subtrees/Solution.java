package find_dup_subtrees;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import nub.Nu.TreeNode;

public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> r = new LinkedList<>();
        if (root == null) return r;
        traverse(root, new HashMap<>(), r);
        return r;
    }

    String traverse(TreeNode node, Map<String, Integer> map, List<TreeNode> r) {
        if (node == null) return "X";
        String s = node.val + "," + traverse(node.left, map, r) + "," + traverse(node.right, map, r);
        if (map.getOrDefault(s, 0) == 1)
            r.add(node);
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
}
