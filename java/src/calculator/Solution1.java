package calculator;
import java.util.Stack;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(new Solution1().calculate("2-1+3"));
    }

    public int calculate(String str) {
        int r = 0, n = 0, sign = 1;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                n = n * 10 + c - '0';
            } else if (c == '-' || c == '+') {
                r += n * sign;
                n = 0;
                if (c == '-') sign = -1;
                else sign = 1;
            } else if (c == '(') {
                s.push(r);
                s.push(sign);
                r = 0;
                sign = 1;
            } else if (c == ')') {
                r += sign * n;
                r = s.pop() * r + s.pop();
                n = 0;
            }
        }
        return r + n * sign;
    }
}
