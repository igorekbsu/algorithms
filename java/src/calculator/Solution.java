package calculator;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("0-2147483647"));
    }

    public int calculate(String str) {
        Stack<Integer> s = new Stack<>();
        char op = '+';
        for (int i = 0, n = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c))
                n = 10 * n + c - '0';
            if (!Character.isDigit(c) && c != ' ' || i == str.length() - 1) {
                if (op == '+') s.push(n);
                else if (op == '-') s.push(-n);
                else if (op == '*') s.push(s.pop() * n);
                else if (op == '/') s.push(s.pop() / n);
                op = c;
                n = 0;
            }
        }
        return s.stream().mapToInt(i -> i).sum();
    }
}