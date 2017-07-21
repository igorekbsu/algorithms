package serialize_bt;
import java.util.LinkedList;
import java.util.Queue;
import nub.Nu.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Codec codec = new Codec();
        String str = codec.serialize(root);
        System.out.println(str);
        TreeNode deserialize = codec.deserialize(str);
        System.out.println(codec.serialize(deserialize));
    }

    public static class Codec {
        public String serialize(TreeNode root) {
            if (root == null) return "";
            Queue<TreeNode> q = new LinkedList<>();
            StringBuilder b = new StringBuilder();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node == null) {
                    b.append("x,");
                    continue;
                }
                b.append(node.val).append(",");
                q.add(node.left);
                q.add(node.right);
            }
            return b.toString();
        }

        public TreeNode deserialize(String data) {
            if (data.length() == 0) return null;
            String[] values = data.split(",");
            Queue<TreeNode> q = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            q.add(root);
            for (int i = 1; i < values.length; i++) {
                TreeNode parent = q.poll();
                if (!values[i].equals("x")) {
                    parent.left = new TreeNode(Integer.parseInt(values[i]));
                    q.add(parent.left);
                }
                if (!values[++i].equals("x")) {
                    parent.right = new TreeNode(Integer.parseInt(values[i]));
                    q.add(parent.right);
                }
            }
            return root;
        }

    }
}
