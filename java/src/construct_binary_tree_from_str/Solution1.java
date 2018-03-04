package construct_binary_tree_from_str;
import java.util.Stack;
import nub.Nu.TreeNode;

public class Solution1 {
    public static void main(String[] args) {
        TreeNode tree = new Solution1().str2tree("2(1)(0)");
        System.out.println(tree);
    }

    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ')') stack.pop();
            else if (a[i] != '(') {
                int sign = 1, n = 0;
                if (a[i] == '-') {
                    sign = -1;
                    i++;
                }
                while (i < a.length && a[i] != '(' && a[i] != ')')
                    n = 10 * n + a[i++] - '0';
                i--;
                TreeNode currentNode = new TreeNode(n * sign);
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left != null) parent.right = currentNode;
                    else parent.left = currentNode;
                }
                stack.push(currentNode);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }
}
