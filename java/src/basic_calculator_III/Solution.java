package basic_calculator_III;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
    }

    public int calculate(String str) {
        Stack<Integer> s = new Stack<>();
        int n = 0, r = 0;
        char sign = '+', a[] = str.toCharArray();
        for (int i = 0; i <= a.length; i++)
            if (i == a.length || a[i] != ' ' && !Character.isDigit(a[i])) {
                if (i < a.length && a[i] == '(') {
                    int l = 1, j = i + 1;
                    for (; j < a.length; j++)
                        if (a[j] == '(') l++;
                        else if (a[j] == ')') {
                            l--;
                            if (l == 0)
                                break;
                        }
                    n = calculate(str.substring(i + 1, j));
                    i = j;
                }
                if (sign == '*')
                    s.push(s.pop() * n);
                else if (sign == '/')
                    s.push(s.pop() / n);
                else if (sign == '-')
                    s.push(-n);
                else if (sign == '+')
                    s.push(n);
                n = 0;
                if (i < a.length)
                    sign = a[i];
            } else if (a[i] == ' ') continue;
            else n = 10 * n + a[i] - '0';
        for (Integer i : s)
            r += i;
        return r;
    }
}
