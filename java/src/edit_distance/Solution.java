package edit_distance;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("a", "b"));
    }

    public int minDistance(String w1, String w2) {
        int[][] dp = new int[w1.length() + 1][w2.length() + 1];
        for (int i = 1; i <= w1.length(); i++)
            dp[i][0] = i;
        for (int i = 1; i <= w2.length(); i++)
            dp[0][i] = i;
        for (int i = 0; i < w1.length(); i++)
            for (int j = 0; j < w2.length(); j++)
                if (w1.charAt(i) == w2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];
                else dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]);
        return dp[w1.length()][w2.length()];
    }
}
