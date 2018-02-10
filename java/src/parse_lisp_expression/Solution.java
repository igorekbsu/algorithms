package parse_lisp_expression;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().evaluate("(let x 1 y 2 x (add x y) (add x y))"));
    }

    public int evaluate(String expression) {
        List<Map<String, Integer>> scope = new ArrayList<>();
        scope.add(new HashMap<>());
        int ans = eval(expression, scope);
        scope.remove(scope.size() - 1);
        return ans;
    }

    public int eval(String expression, List<Map<String, Integer>> scope) {
        if (expression.charAt(0) != '(') {
            if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-')
                return Integer.parseInt(expression);
            for (int i = scope.size() - 1; i >= 0; i--)
                if (scope.get(i).containsKey(expression))
                    return scope.get(i).get(expression);
        }
        List<String> tokens = parse(expression.substring(
                expression.charAt(1) == 'm' ? 6 : 5, expression.length() - 1));
        if (expression.startsWith("add", 1)) {
            return evaluate(tokens.get(0)) + evaluate(tokens.get(1));
        } else if (expression.startsWith("mult", 1)) {
            return evaluate(tokens.get(0)) * evaluate(tokens.get(1));
        } else {
            for (int j = 1; j < tokens.size(); j += 2)
                scope.get(scope.size() - 1).put(tokens.get(j - 1), evaluate(tokens.get(j)));
            return evaluate(tokens.get(tokens.size() - 1));
        }
    }

    public List<String> parse(String expression) {
        List<String> tokens = new ArrayList<>();
        int bal = 0;
        StringBuilder b = new StringBuilder();
        for (String token : expression.split(" ")) {
            for (char c : token.toCharArray())
                if (c == '(') bal++;
                else if (c == ')') bal--;
            if (b.length() > 0) b.append(" ");
            b.append(token);
            if (bal == 0) {
                tokens.add(b.toString());
                b.setLength(0);
            }
        }
        if (b.length() > 0)
            tokens.add(b.toString());
        return tokens;
    }
}