package longest_valid_parens;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("(((((((((((((((((((((((((((((((((((((((((((((())"));
        System.out.println(new Solution().longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String str) {
        LinkedList<Integer> s = new LinkedList<>();
        s.push(-1);
        int len = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ')' && s.size() > 1 && str.charAt(s.peek()) == '(') {
                s.pop();
                len = Math.max(len, i - s.peek());
            } else s.push(i);
        return len;
    }
}
