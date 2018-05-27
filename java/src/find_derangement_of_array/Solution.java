package find_derangement_of_array;
public class Solution {
    public int findDerangement(int n) {
        if (n <= 1) return 0;
        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = (int) ((i - 1L) * (dp[i - 1] + dp[i - 2]) % MOD);
        return dp[n];
    }
}
