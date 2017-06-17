package stack_queue;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public class MyStack {
        Queue<Integer> q = new ArrayDeque<>();

        public void push(int x) {
            q.offer(x);
            for (int i = 1; i < q.size(); i++)
                q.offer(q.remove());
        }

        public int pop() {
            return q.remove();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

    public class MyQueue {
        Stack<Integer> t = new Stack<>(), h = new Stack<>();

        public void push(int x) {
            t.push(x);
        }

        public int pop() {
            peek();
            return h.pop();
        }

        public int peek() {
            if (h.isEmpty()) {
                while (!t.isEmpty())
                    h.push(t.pop());
            }
            return h.peek();
        }

        public boolean empty() {
            return t.isEmpty() && h.isEmpty();
        }
    }
}
