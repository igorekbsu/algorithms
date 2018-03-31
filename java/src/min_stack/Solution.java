package min_stack;
import java.util.Stack;

public class Solution {
    class MinStack {
        final Stack<Integer> s = new Stack<>(), minStack = new Stack<>();
        int min;

        public void push(int x) {
            s.push(x);
            if (minStack.isEmpty() || x <= minStack.peek())
                minStack.push(x);
        }

        public void pop() {
            Integer pop = s.pop();
            if (minStack.peek().equals(pop))
                minStack.pop();
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
