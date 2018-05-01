package split_bst;
import java.util.Arrays;
import nub.Nu.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(Arrays.toString(new Solution().splitBST(root, 1)));
    }
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] r = new TreeNode[2];
        if (root == null) return r;
        if (root.val <= V) {
            r[0] = root;
            TreeNode[] right = splitBST(root.right, V);
            root.right = right[0];
            r[1] = right[1];
        } else {
            r[1] = root;
            TreeNode[] left = splitBST(root.left, V);
            root.left = left[1];
            r[0] = left[0];
        }
        return r;
    }
}
