package gen_parentheses;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> r = new LinkedList<>();
        genParen("", r, 0, 2 * n);
        return r;
    }

    void genParen(String s, List<String> r, int open, int n) {
        if (s.length() == n) {
            if (open == 0)
                r.add(s);
        } else {
            genParen(s + ")", r, open - 1, n);
            if (open >= 0)
                genParen(s + "(", r, open + 1, n);
        }
    }
}
