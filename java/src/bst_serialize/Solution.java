package bst_serialize;
import java.util.ArrayDeque;
import java.util.Queue;

class Codec {
    public String serialize(TreeNode root) {
        StringBuilder b = new StringBuilder();
        traverse(root, b);
        b.deleteCharAt(b.length() - 1);
        return b.toString();
    }

    void traverse(TreeNode node, StringBuilder b) {
        if (node == null) b.append("X,");
        else {
            b.append(node.val).append(",");
            traverse(node.left, b);
            traverse(node.right, b);
        }
    }

    public TreeNode deserialize(String data) {
        String[] parts = data.split(",");
        Queue<String> q = new ArrayDeque<>(parts.length);
        for (int i = 0; i < parts.length; i++)
            q.add(parts[i]);
        return buildTree(q);
    }

    TreeNode buildTree(Queue<String> q) {
        String value = q.remove();
        if(value.equals("X"))return null;
        else{
            TreeNode node = new TreeNode(Integer.parseInt(value));
            node.left = buildTree(q);
            node.right = buildTree(q);
            return node;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}