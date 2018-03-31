package delete_operation_for_two_strings;
public class Solution {
    public int minDistance(String w1, String w2) {
        int[][] dp = new int[w1.length() + 1][w2.length() + 1];
        for (int i = 0; i < w1.length(); i++)
            for (int j = 0; j < w2.length(); j++)
                if (w1.charAt(i) == w2.charAt(j))
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                else dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
        return w1.length() + w2.length() - 2 * dp[w1.length()][w2.length()];
    }
}
