package validate_stack_sequences;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(new Solution().validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        for (int x : pushed) {
            s.push(x);
            while (!s.empty() && s.peek() == popped[i]) {
                s.pop();
                i++;
            }
        }
        return i == popped.length;
    }
}
