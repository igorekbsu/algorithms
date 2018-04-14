package super_ugly_number;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n], idx = new int[primes.length];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * dp[idx[j]] == dp[i - 1])
                    idx[j]++;
                dp[i] = Math.min(dp[i], primes[j] * dp[idx[j]]);
            }
        }
        return dp[n - 1];
    }
}
