package sum_of_subsequence_widths;
import java.util.Arrays;

public class Solution {
    public int sumSubseqWidths(int[] A) {
        int MOD = 1_000_000_007, N = A.length;
        Arrays.sort(A);
        long[] p2 = new long[N];
        p2[0] = 1;
        for (int i = 1; i < N; ++i)
            p2[i] = p2[i - 1] * 2 % MOD;
        long sum = 0;
        for (int i = N - 1; i >= 0; i--) {
            sum += (p2[i] - 1) * A[i] % MOD;
            sum -= (p2[N - 1 - i] - 1) * A[i] % MOD;
            sum = Math.floorMod(sum, MOD);
        }

        return (int) sum;
    }
}
