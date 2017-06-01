public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("412"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            int d = Character.digit(s.charAt(i - 1), 10);
            if (d > 0) dp[i] += dp[i - 1];
            d = Integer.parseInt(s.substring(i - 2, i));
            if (d >= 10 && d <= 26) dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
