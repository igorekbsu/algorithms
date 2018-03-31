package spiral_matrix;
public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            for (int j = 0; j < word2.length(); j++)
                if (c == word2.charAt(j))
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
        }
        return word1.length() + word2.length() - 2*dp[word1.length()][word2.length()];
    }
}
