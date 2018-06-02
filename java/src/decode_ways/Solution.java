package decode_ways;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("10"));
    }

    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        char[] a = s.toCharArray();
        int[] dp = new int[a.length + 1];
        dp[a.length] = 1;
        dp[a.length - 1] = a[a.length - 1] == '0' ? 0 : 1;
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] == '0') continue;
            dp[i] = 10 * (a[i] - '0') + a[i + 1] - '0' <= 26 ? dp[i + 1] + dp[i + 2] : dp[i + 1];
        }
        return dp[0];
    }
}
