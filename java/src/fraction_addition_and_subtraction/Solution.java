package fraction_addition_and_subtraction;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().fractionAddition("-1/2+1/2+1/3"));
    }

    public String fractionAddition(String s) {
        List<Integer> nums = new LinkedList<>(), dens = new LinkedList<>();
        long B = 1;
        int sign = s.charAt(0) == '-' ? -1 : 1, n = 0;
        for (int i = sign == -1 ? 1 : 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '/') {
                nums.add(sign * n);
                n = 0;
                sign = 1;
            } else if (Character.isDigit(c))
                n = 10 * n + c - '0';
            else {
                dens.add(sign * n);
                B *= n;
                sign = c == '+' ? 1 : -1;
                n = 0;
            }
        }
        dens.add(n * sign);
        B *= n;
        long A = 0;
        for (int i = 0; i < nums.size(); i++)
            A += nums.get(i) * (B / dens.get(i));
        int gcd = gcd(A, B);
        return A / gcd + "/" + B / gcd;
    }

    int gcd(long a, long b) {
        return a != 0 ? gcd(b % a, a) : (int) Math.abs(b);
    }
}
