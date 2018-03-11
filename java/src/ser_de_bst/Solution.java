package ser_de_bst;
import static nub.Nu.TreeNode;

public class Solution {
    public static void main(String[] args) {
        Codec c = new Codec();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(c.serialize(root));
        TreeNode deserialize = c.deserialize(c.serialize(root));
        System.out.println(deserialize);
    }

    public static class Codec {
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder b = new StringBuilder();
            b.append(root.val);
            if (root.left != null)
                b.append(",").append(serialize(root.left));
            if (root.right != null)
                b.append(",").append(serialize(root.right));
            return b.toString();

        }

        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            String[] parts = data.split(",");
            int[] values = new int[parts.length];
            for (int i = 0; i < values.length; i++)
                values[i] = Integer.parseInt(parts[i]);
            return toTree(values, 0, values.length - 1);
        }

        TreeNode toTree(int[] values, int lo, int hi) {
            if (lo > hi) return null;
            int val = values[lo];
            int nextHi = hi + 1;
            for (int i = lo + 1; i <= hi; i++)
                if (values[i] > val) {
                    nextHi = i;
                    break;
                }
            TreeNode node = new TreeNode(val);
            node.left = toTree(values, lo + 1, nextHi - 1);
            node.right = toTree(values, nextHi, hi);
            return node;
        }
    }
}
