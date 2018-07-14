package n_ary_tree_preorder_traversal;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import nub.Nu.Node;

public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> r = new LinkedList<>();
        if (root == null) return r;
        Stack<Node> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            Node node = s.pop();
            r.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--)
                s.push(node.children.get(i));
        }
        return r;
    }
}
