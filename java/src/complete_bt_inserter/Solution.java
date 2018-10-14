package complete_bt_inserter;
import java.util.ArrayList;
import java.util.List;
import nub.Nu.TreeNode;

public class Solution {
    class CBTInserter {
        final List<TreeNode> tree = new ArrayList<>();

        public CBTInserter(TreeNode root) {
            tree.add(root);
            for (int i = 0; i < tree.size(); i++) {
                if (tree.get(i).left != null)
                    tree.add(tree.get(i).left);
                if (tree.get(i).right != null)
                    tree.add(tree.get(i).right);
            }
        }

        public int insert(int v) {
            int n = tree.size();
            TreeNode node = new TreeNode(v);
            tree.add(node);
            TreeNode p = tree.get((n - 1) / 2);
            if (n % 2 == 0)
                p.left = node;
            else p.right = node;
            return p.val;
        }

        public TreeNode get_root() {
            return tree.get(0);
        }
    }
}
