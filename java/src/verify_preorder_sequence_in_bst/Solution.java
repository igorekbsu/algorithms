package verify_preorder_sequence_in_bst;
import java.util.Stack;

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        for (int p : preorder) {
            if (p < low)
                return false;
            while (!s.empty() && p > s.peek())
                low = s.pop();
            s.push(p);
        }
        return true;
    }
}
