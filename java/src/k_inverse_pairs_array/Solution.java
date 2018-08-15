package k_inverse_pairs_array;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().kInversePairs(3, 1));
    }

    public int kInversePairs(int n, int k) {
        int MOD = 1_000_000_007;
        if (k > n * (n - 1) / 2)
            return 0;
        int[][] dp = new int[n + 1][k + 1];
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            long sum = 0;
            for (int j = 0; j <= k; j++) {
                sum += dp[i - 1][j];
                if (j - i >= 0)
                    sum -= dp[i - 1][j - i];
                dp[i][j] = (int) (sum % MOD);
            }
        }
        return dp[n][k];
    }
}
