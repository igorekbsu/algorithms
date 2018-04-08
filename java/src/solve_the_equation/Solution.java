package solve_the_equation;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solveEquation("0x=0"));
    }

    public String solveEquation(String equation) {
        int a[] = new int[2], sign = 1, n = 0, i = 1, side = 1;
        for (int j = 0; j < equation.length(); j++) {
            char c = equation.charAt(j);
            if (Character.isDigit(c))
                n = 10 * n + c - '0';
            else if (c == 'x') {
                i = 0;
                if (j == 0 || !Character.isDigit(equation.charAt(j - 1)))
                    n = 1;
            } else if (c == '+' || c == '-' || c == '=') {
                a[i] += sign * side * n;
                n = 0;
                i = 1;
                sign = c == '-' ? -1 : 1;
                if (c == '=')
                    side = -1;
            }
        }
        a[i] += sign * side * n;
        if (a[0] == 0 && a[1] == 0) return "Infinite solutions";
        if (a[0] == 0) return "No solution";
        return "x=" + a[1] / -a[0];
    }
}
