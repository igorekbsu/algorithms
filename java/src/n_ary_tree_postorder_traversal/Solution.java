package n_ary_tree_postorder_traversal;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import nub.Nu.Node;

public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> r = new LinkedList<>();
        if(root == null)return r;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            Node node = s.pop();
            r.add(0, node.val);
            for (Node n : node.children)
                s.push(n);
        }
        return r;
    }
}
