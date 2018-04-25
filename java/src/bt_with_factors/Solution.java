package bt_with_factors;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        long dp[] = new long[A.length], r = 0, MOD = 1_000_000_007;
        Arrays.fill(dp, 1);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < A.length; i++)
            m.put(A[i], i);
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < i; j++)
                if (A[i] % A[j] == 0) {
                    int right = A[i] / A[j];
                    if (m.containsKey(right))
                        dp[i] = (dp[i] + dp[j] * dp[m.get(right)]) % MOD;
                }
        for (long val : dp)
            r += val;
        return (int) (r % MOD);
    }
}
