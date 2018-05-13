package bt_longest_consecutive_sequence_II;
import nub.Nu.TreeNode;

public class Solution {
    int maxLen = 0;

    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return maxLen;
    }

    int[] longestPath(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int desc = 1, asc = 1;
        if (root.left != null) {
            int[] len = longestPath(root.left);
            if (root.val == root.left.val + 1)
                asc = len[1] + 1;
            else if (root.val == root.left.val - 1)
                desc = len[0] + 1;
        }
        if (root.right != null) {
            int[] len = longestPath(root.right);
            if (root.val == root.right.val + 1)
                asc = Math.max(asc, len[1] + 1);
            else if (root.val == root.right.val - 1)
                desc = Math.max(desc, len[0] + 1);
        }
        maxLen = Math.max(maxLen, asc + desc - 1);
        return new int[]{desc, asc};
    }
}
