package construct_binary_tree_from_str;
import nub.Nu.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode node = new Solution().str2tree("4(2(3)(1))(6(5))");
        System.out.println(node);
    }

    public TreeNode str2tree(String s) {
        char[] a = s.toCharArray();
        return str2tree(a, 0, a.length - 1);
    }

    TreeNode str2tree(char[] a, int i, int j) {
        if (i > j) return null;
        int n = 0, sign = 1;
        if (a[i] == '-') {
            sign = -1;
            i++;
        }
        while (i < a.length && a[i] != '(' && a[i] != ')')
            n = 10 * n + a[i++] - '0';
        n *= sign;
        TreeNode node = new TreeNode(n);
        if (i < a.length && a[i] == '(') {
            int balance = 1, k = i;
            while (++k <= j) {
                if (a[k] == '(') balance++;
                else if (a[k] == ')') balance--;
                if (balance == 0) break;
            }
            node.left = str2tree(a, i + 1, k - 1);
            node.right = str2tree(a, k + 2, j - 1);
        }
        return node;
    }
}
