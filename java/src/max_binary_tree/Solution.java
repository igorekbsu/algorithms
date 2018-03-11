package max_binary_tree;
import static nub.Nu.TreeNode;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxBinTree(nums, 0, nums.length - 1);
    }

    TreeNode maxBinTree(int[] a, int lo, int hi) {
        if (lo > hi) return null;
        int maxi = lo;
        for (int i = lo + 1; i <= hi; i++)
            if (a[maxi] < a[i])
                maxi = i;
        TreeNode node = new TreeNode(a[maxi]);
        node.left = maxBinTree(a, lo, maxi - 1);
        node.right = maxBinTree(a, maxi + 1, hi);
        return node;
    }
}
