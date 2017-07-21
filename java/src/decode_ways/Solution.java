package decode_ways;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("110255"));
    }

    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        char[] chars = s.toCharArray();
        dp[0] = 1; dp[1] = chars[0] == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int d = chars[i - 1] - '0';
            if (d > 0)
                dp[i] += dp[i - 1];
            d = 10 * (chars[i - 2] - '0') + d;
            if (d >= 10 && d <= 26) dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
