package serde_nary_tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import nub.Nu.Node;

public class Solution {
    class Codec {
        public String serialize(Node root) {
            List<String> list = new LinkedList<>();
            ser(root, list);
            return String.join(",", list);
        }

        void ser(Node root, List<String> list) {
            if (root != null) {
                list.add(String.valueOf(root.val));
                list.add(String.valueOf(root.children.size()));
                for (Node child : root.children)
                    ser(child, list);
            }
        }

        public Node deserialize(String data) {
            if (data.isEmpty())
                return null;
            Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
            return des(q);
        }

        Node des(Queue<String> q) {
            int val = Integer.parseInt(q.poll()), size = Integer.parseInt(q.poll());
            List<Node> children = new ArrayList<>(size);
            for (int i = 0; i < size; i++)
                children.add(des(q));
            return new Node(val, children);
        }
    }
}
