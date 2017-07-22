package count_smaller_after_self;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] a = {7, 1, 7, 9, 7, 7};
        System.out.println(new Solution().countSmaller(a));
    }

    public List<Integer> countSmaller(int[] a) {
        Integer[] counts = new Integer[a.length];
        Node root = null;
        for (int i = a.length - 1; i >= 0; i--)
            root = insert(root, a[i], 0, i, counts);
        return Arrays.asList(counts);
    }

    Node insert(Node node, int val, int count, int i, Integer[] r) {
        if (node == null) {
            r[i] = count;
            return new Node(val, 0);
        } else if (val > node.val) {
            node.right = insert(node.right, val, count + node.count + 1, i, r);
        } else if (val < node.val) {
            node.count++;
            node.left = insert(node.left, val, count, i, r);
        } else {
            node.count++;
            r[i] = count;
        }
        return node;
    }

    class Node {
        int val, count;
        Node left, right;

        Node(int val, int count) { this.val = val; this.count = count;}

        @Override public String toString() {
            return val + ":" + count;
        }
    }
}
