package n_ary_tree_level_order_traversal;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import nub.Nu.Node;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> r = new LinkedList<>();
        if (root == null) return r;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            for (int size = q.size(); size > 0; size--) {
                Node node = q.poll();
                list.add(node.val);
                for (Node kid : node.children)
                    q.offer(kid);
            }
            r.add(list);
        }
        return r;
    }
}
