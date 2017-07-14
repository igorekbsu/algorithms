package bst_it;
import java.util.Stack;
import static nub.Nu.TreeNode;

public class Solution {
    public class BSTIterator {
        Stack<TreeNode> s = new Stack<>();

        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        public boolean hasNext() {
            return !s.isEmpty();
        }

        public int next() {
            TreeNode node = s.pop();
            pushAll(node.right);
            return node.val;
        }

        void pushAll(TreeNode n) {
            for (; n != null; n = n.left)
                s.push(n);
        }
    }
}
