package serde_bt;
import java.util.Arrays;
import java.util.LinkedList;
import nub.Nu.TreeNode;

public class Solution {
    public class Codec {
        public String serialize(TreeNode root) {
            StringBuilder s = new StringBuilder();
            ser(root, s);
            return s.toString();
        }

        void ser(TreeNode node, StringBuilder s) {
            if (node == null)
                s.append("#").append(",");
            else {
                s.append(node.val).append(",");
                ser(node.left, s);
                ser(node.right, s);
            }
        }

        public TreeNode deserialize(String data) {
            LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
            return des(list);
        }

        TreeNode des(LinkedList<String> vals) {
            String val = vals.poll();
            if (val.equals("#"))
                return null;
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = des(vals);
            node.right = des(vals);
            return node;
        }
    }
}
