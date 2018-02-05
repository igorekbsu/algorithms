package valid_parens;
import java.util.Stack;

public class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (char c : str.toCharArray())
            if (c == '(') s.push(')');
            else if (c == '[') s.push(']');
            else if (c == '{') s.push('}');
            else if (s.isEmpty() || s.pop() != c) return false;
        return s.isEmpty();
    }
}
