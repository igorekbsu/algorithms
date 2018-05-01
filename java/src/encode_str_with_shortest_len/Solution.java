package encode_str_with_shortest_len;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().encode("aaaaa"));
    }

    public String encode(String s) {
        String[][] dp = new String[s.length()][s.length()];
        for (int len = 0; len < s.length(); len++)
            for (int i = 0; i < s.length() - len; i++) {
                int j = i + len;
                String sub = s.substring(i, j + 1);
                if (j - i < 4)
                    dp[i][j] = sub;
                else {
                    dp[i][j] = sub;
                    // Loop for trying all results that we get after dividing the strings into 2 and combine the   results of 2 substrings
                    for (int k = i; k < j; k++)
                        if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length())
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                    for (int k = 0; k < sub.length(); k++) {
                        String repeat = sub.substring(0, k + 1);
                        if (sub.length() % repeat.length() == 0 && sub.replaceAll(repeat, "").length() == 0) {
                            String ss = sub.length() / repeat.length() + "[" + dp[i][i + k] + "]";
                            if (ss.length() < dp[i][j].length())
                                dp[i][j] = ss;
                        }
                    }
                }
            }
        return dp[0][s.length() - 1];
    }
}
