package serialize_and_deserialize_bt;
import java.util.Arrays;
import java.util.LinkedList;
import nub.Nu.TreeNode;

public class Solution {
    public class Codec {
        public String serialize(TreeNode root) {
            return ser(root);
        }

        String ser(TreeNode root) {
            if (root == null)
                return "#";
            StringBuilder b = new StringBuilder().append(root.val).append(",");
            b.append(ser(root.left)).append(',');
            b.append(ser(root.right));
            return b.toString();
        }

        public TreeNode deserialize(String data) {
            LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
            return des(list);
        }

        TreeNode des(LinkedList<String> list) {
            String val = list.poll();
            if (val.equals("#"))
                return null;
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = des(list);
            root.right = des(list);
            return root;
        }
    }
}
