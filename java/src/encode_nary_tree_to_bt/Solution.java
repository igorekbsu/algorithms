package encode_nary_tree_to_bt;
import java.util.LinkedList;
import java.util.List;
import nub.Nu.Node;
import nub.Nu.TreeNode;

public class Solution {
    class Codec {
        public TreeNode encode(Node root) {
            if (root == null)
                return null;
            TreeNode bt = new TreeNode(root.val);
            if (root.children.isEmpty())
                return bt;
            bt.left = encode(root.children.get(0));
            TreeNode node = bt.left;
            for (int i = 1; i < root.children.size(); i++) {
                node.right = encode(root.children.get(i));
                node = node.right;
            }
            return bt;
        }

        public Node decode(TreeNode root) {
            if (root == null)
                return null;
            List<Node> children = new LinkedList<>();
            TreeNode bt = root.left;
            while (bt != null) {
                children.add(decode(bt));
                bt = bt.right;
            }
            return new Node(root.val, children);
        }
    }
}
