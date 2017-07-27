package gen_parentheses;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> r = new LinkedList<>();
        gen(n * 2, "", r, 0);
        return r;
    }

    void gen(int n, String s, List<String> r, int count) {
        if (s.length() == n) {
            if (count == 0)
                r.add(s);
        } else {
            gen(n, s + "(", r, count + 1);
            if (count > 0)
                gen(n, s + ")", r, count - 1);
        }
    }
}
