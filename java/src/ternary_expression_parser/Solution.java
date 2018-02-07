package ternary_expression_parser;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().parseTernary("F?1:T?4:5"));
        System.out.println(new Solution().parseTernary("T?T:F?T?1:2:F?3:4"));
    }

    public String parseTernary(String e) {
        Deque<Character> stack = new ArrayDeque<>(e.length());
        for (int i = e.length() - 1; i >= 0; i--) {
            char c = e.charAt(i);
            if (c == '?') {
                char condition = e.charAt(i - 1);
                char first = stack.pop(), second = stack.pop();
                stack.push(condition == 'T' ? first : second);
                i--;
            } else if (c != ':')
                stack.push(c);
        }
        return stack.pop().toString();
    }
}