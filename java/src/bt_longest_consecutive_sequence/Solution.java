package bt_longest_consecutive_sequence;
import nub.Nu.TreeNode;

public class Solution {
    int maxLen = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        maxLen(root, root.val, 0);
        return maxLen;
    }

    void maxLen(TreeNode node, int val, int len) {
        if (node == null) return;
        if (node.val == val) len++;
        else len = 1;
        maxLen = Math.max(maxLen, len);
        maxLen(node.left, node.val + 1, len);
        maxLen(node.right, node.val + 1, len);
    }
}
