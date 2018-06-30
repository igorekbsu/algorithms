package decode_ways;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("226"));
    }

    public int numDecodings(String s) {
        char[] a = s.toCharArray();
        int n = a.length, dp[] = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = a[n - 1] == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--)
            if (a[i] != '0')
                dp[i] = (10 * (a[i] - '0') + a[i + 1] - '0') <= 26 ? dp[i + 1] + dp[i + 2] : dp[i + 1];
        return dp[0];
    }
}
