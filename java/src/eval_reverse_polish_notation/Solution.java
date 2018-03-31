package eval_reverse_polish_notation;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[]{"4", "-2", "/", "2", "-3", "-", "-"}));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> s = new ArrayDeque<>(tokens.length);
        for (String token : tokens)
            switch (token) {
                case "/":
                    Integer last = s.pop();
                    s.push(s.pop() / last);
                    break;
                case "*":
                    s.push(s.pop() * s.pop());
                    break;
                case "+":
                    s.push(s.pop() + s.pop());
                    break;
                case "-":
                    s.push(-s.pop() + s.pop());
                    break;
                default:
                    s.push(Integer.parseInt(token));
            }
        return s.pop();
    }
}
