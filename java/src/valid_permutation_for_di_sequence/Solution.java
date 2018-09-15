package valid_permutation_for_di_sequence;
import java.util.Arrays;

public class Solution {
    public int numPermsDISequence(String S) {
        int MOD = 1_000_000_007, N = S.length();
        int[][] dp = new int[N + 1][N + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= N; ++i)
            for (int j = 0; j <= i; ++j)
                if (S.charAt(i - 1) == 'D')
                    for (int k = j; k < i; ++k)
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                else for (int k = 0; k < j; ++k)
                    dp[i][j] = (dp[i - 1][k] + dp[i][j]) % MOD;
        int r = 0;
        for (int x : dp[N])
            r = (x + r) % MOD;
        return r;
    }
}
