package basic_calculator;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("1-(4+3)"));
    }

    public int calculate(String str) {
        Stack<Integer> s = new Stack<>();
        int r = 0, sign = 1, n = 0;
        for (char c : str.toCharArray())
            if (c == '(') {
                s.push(r);
                s.push(sign);
                r = 0;
                sign = 1;
            } else if (c == ')') {
                r += sign * n;
                r = s.pop() * r + s.pop();
                n = 0;
                sign = 1;
            } else if (c == ' ') continue;
            else if (c == '+' || c == '-') {
                r += sign * n;
                n = 0;
                sign = c == '+' ? 1 : -1;
            } else n = 10 * n + c - '0';
        return r + sign * n;
    }
}
