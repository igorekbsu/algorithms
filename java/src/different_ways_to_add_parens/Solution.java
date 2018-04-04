package different_ways_to_add_parens;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> r = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '*' || c == '-' || c == '+')
                for (int a : diffWaysToCompute(input.substring(0, i)))
                    for (int b : diffWaysToCompute(input.substring(i + 1)))
                        r.add(c == '+' ? a + b : c == '-' ? a - b : a * b);
        }
        if (r.isEmpty())
            r.add(Integer.parseInt(input));
        return r;
    }
}
