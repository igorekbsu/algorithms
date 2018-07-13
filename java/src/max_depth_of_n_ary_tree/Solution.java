package max_depth_of_n_ary_tree;
import java.util.List;

class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 1;
        for (Node kid : root.children)
            depth = Math.max(depth, 1 + maxDepth(kid));
        return depth;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}