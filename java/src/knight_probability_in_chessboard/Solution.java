package knight_probability_in_chessboard;
public class Solution {
    public double knightProbability(int n, int k, int sr, int sc) {
        double[][] dp = new double[n][n];
        int[] mx = {2, 2, 1, 1, -1, -1, -2, -2};
        int[] my = {1, -1, 2, -2, 2, -2, 1, -1};
        dp[sr][sc] = 1;
        for (; k > 0; k--) {
            double[][] dp2 = new double[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    for (int m = 0; m < 8; m++) {
                        int nx = i + mx[m], ny = j + my[m];
                        if (0 <= nx && nx < n && 0 <= ny && ny < n)
                            dp2[nx][ny] += dp[i][j] / 8.0;
                    }
            dp = dp2;
        }
        double r = 0;
        for (double[] row : dp)
            for (double v : row)
                r += v;
        return r;
    }
}
