package min_window_subsequence;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("cabd", "ab"));
    }

    public String minWindow(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++)
            dp[0][i] = i + 1;
        for (int i = 1; i <= t.length(); i++)
            for (int j = 1; j <= s.length(); j++)
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = dp[i][j - 1];
        int start = 0, len = s.length() + 1, n = t.length();
        for(int i = 0; i <= s.length(); i++)
            if(dp[n][i] != 0 && i - dp[n][i] + 1 < len){
                start = dp[n][i] - 1;
                len = i - dp[n][i] + 1;
            }
        return len > s.length()? "": s.substring(start, start + len);
    }
}
