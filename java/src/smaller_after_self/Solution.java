package smaller_after_self;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] a = {10, 0, 3, 2, 2, 6, 1};
        System.out.println(new Solution().countSmaller(a));

    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] r = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--)
            root = insert(root, nums[i], i, r, 0);
        return Arrays.asList(r);
    }

    Node insert(Node node, int val, int i, Integer[] r, int count) {
        if (node == null) {
            node = new Node(val);
            r[i] = count;
        } else if (node.val == val) {
            node.dup++;
            r[i] = node.leftCount + count;
        } else if (val > node.val) {
            node.right = insert(node.right, val, i, r, count + node.dup + node.leftCount);
        } else {
            node.leftCount++;
            node.left = insert(node.left, val, i, r, count);
        }
        return node;
    }

    class Node {
        int dup = 1, leftCount, val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }
}
