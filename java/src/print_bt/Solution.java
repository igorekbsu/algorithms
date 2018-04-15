package print_bt;
import java.util.ArrayList;
import java.util.List;
import nub.Nu.TreeNode;

public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int H = height(root), W = (int) Math.pow(2, H) - 1;
        List<List<String>> r = new ArrayList<>(H);
        List<String> row = new ArrayList<>(W);
        for (int i = 0; i < W; i++)
            row.add("");
        for (int i = 0; i < H; i++)
            r.add(new ArrayList<>(row));
        populate(root, r, 0, 0, W);
        return r;
    }

    void populate(TreeNode node, List<List<String>> r, int row, int lo, int hi) {
        if (node == null || row == r.size()) return;
        int i = (lo + hi) / 2;
        r.get(row).set(i, Integer.toString(node.val));
        populate(node.left, r, row + 1, lo, lo + i - 1);
        populate(node.right, r, row + 1, lo + i + 1, hi);
    }

    int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
