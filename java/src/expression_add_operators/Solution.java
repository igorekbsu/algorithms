package expression_add_operators;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().addOperators("123", 6));
    }

    public List<String> addOperators(String num, int target) {
        List<String> r = new LinkedList<>();
        StringBuilder expr = new StringBuilder();
        addOperators(num, expr, 0, 0, target, r, 0);
        return r;
    }

    void addOperators(String num, StringBuilder expr, int pos, long val, int target, List<String> r, long last) {
        if (pos == num.length()) {
            if (val == target)
                r.add(expr.toString());
        } else {
            for (int i = pos; i < num.length(); i++) {
                if (i != pos && num.charAt(pos) == '0') break;
                long n = Long.parseLong(num.substring(pos, i + 1));
                int len = expr.length();
                if (pos == 0) {
                    addOperators(num, expr.append(n), i + 1, n, target, r, n);
                    expr.setLength(len);
                }else {
                    addOperators(num, expr.append('+').append(n), i + 1, val + n, target, r, n);
                    expr.setLength(len);
                    addOperators(num, expr.append('-').append(n), i + 1, val - n, target, r, -n);
                    expr.setLength(len);
                    addOperators(num, expr.append('*').append(n), i + 1, val - last + last * n, target, r, last * n);
                    expr.setLength(len);
                }
            }
        }
    }
}