package pow;
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(2, Integer.MIN_VALUE));
        System.out.println(s.myPow(2, -1));
    }

    public double myPow(double x, int n) {
        if (x == 1) return 1;
        if (n == 0) return 1;
        if (n < 0)
            return (1 / x) * myPow(1 / x, -(n + 1));
        if (n == 2) return x * x;
        double correction = 1;
        if (n % 2 == 1) {
            correction = x;
            n--;
        }
        double product = myPow(x, n / 2);
        return correction * product * product;
    }
}
