package preimage_size_of_factorial_zeroes_function;
public class Solution {
    public int preimageSizeFZF(int K) {
        long lo = K, hi = 5 * K + 1;
        while (lo < hi) {
            long m = lo + (hi - lo) / 2, zeroes = zeroes(m);
            if (zeroes == K) return 5;
            else if (zeroes < K) lo = m + 1;
            else hi = m - 1;
        }
        return 0;
    }

    long zeroes(long x) {
        if (x == 0) return 0;
        return x / 5 + zeroes(x / 5);
    }
}
