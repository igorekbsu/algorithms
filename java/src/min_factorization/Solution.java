package min_factorization;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().smallestFactorization(1000));
    }

    public int smallestFactorization(int a) {
        if (a < 10) return a;
        long r = 0, mul = 1;
        for (int i = 9; i >= 2; i--)
            while (a % i == 0) {
                a /= i;
                r = mul * i + r;
                mul *= 10;
            }
        return a == 1 && r <= Integer.MAX_VALUE ? (int) r : 0;
    }
}
