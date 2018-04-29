package construct_bt_from_inorder_and_postorder;
import java.util.HashMap;
import java.util.Map;
import nub.Nu.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode x = new Solution().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        System.out.println(x);
    }

    public TreeNode buildTree(int[] in, int[] post) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < in.length; i++)
            m.put(in[i], i);
        return build(in, 0, in.length - 1, post, 0, in.length - 1, m);
    }

    TreeNode build(int[] in, int i1, int i2, int[] post, int p1, int p2, Map<Integer, Integer> m) {
        if (i1 > i2) return null;
        TreeNode root = new TreeNode(post[p2]);
        int r = m.get(root.val);
        root.left = build(in, i1, r - 1, post, p1, p1 + r - i1 - 1, m);
        root.right = build(in, r + 1, i2, post, p1 + r - i1, p2 - 1, m);
        return root;
    }
}
