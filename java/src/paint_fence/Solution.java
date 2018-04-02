package paint_fence;
public class Solution {
    public int numWays(int n, int k) {
        int[] dp = new int[Math.min(n + 1, 3)];
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i <= n; i++)
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        return dp[n];
    }
}
