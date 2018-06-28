package recover_bst;
import nub.Nu.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(3);
        new Solution().morrisTraversal(root);
    }

    public void recoverTree(TreeNode root) {

    }

    public void morrisTraversal(TreeNode root) {
        TreeNode temp;
        while (root != null) {
            if (root.left != null) {
                // connect threading for root
                temp = root.left;
                while (temp.right != null && temp.right != root)
                    temp = temp.right;
                // the threading already exists
                if (temp.right != null) {
                    temp.right = null;
                    System.out.println(root.val);
                    root = root.right;
                } else {
                    // construct the threading
                    temp.right = root;
                    root = root.left;
                }
            } else {
                System.out.println(root.val);
                root = root.right;
            }
        }
    }
}
