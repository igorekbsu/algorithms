package basic_calculator_II;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("3+2*2"));
    }

    public int calculate(String str) {
        Stack<Integer> s = new Stack<>();
        char sign = '+', a[] = str.toCharArray();
        for (int i = 0, n = 0; i < str.length(); i++) {
            boolean digit = Character.isDigit(a[i]);
            if (digit)
                n = 10 * n + a[i] - '0';
            if (i == a.length - 1 || (a[i] != ' ' && !digit)) {
                if (sign == '+')
                    s.push(n);
                else if (sign == '-')
                    s.push(-n);
                else if (sign == '*')
                    s.push(s.pop() * n);
                else if (sign == '/')
                    s.push(s.pop() / n);
                sign = a[i];
                n = 0;
            }
        }
        int r = 0;
        for (Integer i : s)
            r += i;
        return r;
    }
}
