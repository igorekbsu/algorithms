package ugly_number;
public class Solution2 {
    public int nthUglyNumber(int n) {
        int dp[] = new int[n], i2 = 0, i3 = 0, i5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (dp[i] == dp[i2] * 2) i2++;
            if (dp[i] == dp[i3] * 3) i3++;
            if (dp[i] == dp[i5] * 5) i5++;
        }
        return dp[n - 1];
    }
}
