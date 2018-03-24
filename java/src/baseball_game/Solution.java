package baseball_game;
import java.util.Stack;

public class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> s = new Stack<>();
        for (String op : ops)
            if (op.equals("C"))
                s.pop();
            else if (op.equals("D"))
                s.push(s.peek() * 2);
            else if (op.equals("+")) {
                Integer n = s.pop(), sum = n + s.peek();
                s.push(n); s.push(sum);
            } else s.push(Integer.parseInt(op));
        int sum = 0;
        while (!s.isEmpty())
            sum += s.pop();
        return sum;
    }
}
