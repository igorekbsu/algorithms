package basic_calculator;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("1 - (2 + 1)"));
    }

    public int calculate(String str) {
        Stack<Integer> s = new Stack<>();
        int r = 0, sign = 1, n = 0;
        s.push(sign);
        for (char c : str.toCharArray())
            if (Character.isDigit(c))
                n = 10 * n + c - '0';
            else if (c == '(')
                s.push(sign);
            else if (c == ')')
                s.pop();
            else if (c == '+' || c == '-') {
                r += sign * n;
                sign = (c == '+' ? 1 : -1) * s.peek();
                n = 0;
            }
        return r + sign * n;
    }
}
