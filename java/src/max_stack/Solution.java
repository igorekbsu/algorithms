package max_stack;
import java.util.Stack;

public class Solution {
    class MaxStack {
        final Stack<Integer> s = new Stack<>(), maxStack = new Stack<>();

        public void push(int x) {
            s.push(x);
            if (maxStack.isEmpty() || x >= maxStack.peek())
                maxStack.push(x);
        }

        public int pop() {
            Integer n = s.pop();
            if (maxStack.peek().equals(n))
                maxStack.pop();
            return n;
        }

        public int top() {
            return s.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int max = maxStack.pop();
            Stack<Integer> tmp = new Stack<>();
            while (s.peek() != max)
                tmp.push(s.pop());
            s.pop();
            while (!tmp.isEmpty())
                push(tmp.pop());
            return max;
        }
    }
}
