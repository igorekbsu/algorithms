import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().parseTernary("F?1:T?4:5"));
    }

    public String parseTernary(String expression) {
        Stack<Character> s = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (c == '?') {
                char con = expression.charAt(i - 1);
                i--;
                char arg1 = s.pop(), arg2 = s.pop();
                s.push(con == 'T' ? arg1 : arg2);
            } else if (c != ':') s.push(c);
        }
        return s.pop() + "";
    }
}
