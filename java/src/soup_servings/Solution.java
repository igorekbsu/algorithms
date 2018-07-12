package soup_servings;
public class Solution {
    public double soupServings(int N) {
        return N >= 4800 ? 1.0 : f((N + 24) / 25, (N + 24) / 25, new double[N + 1][N + 1]);
    }

    double f(int a, int b, double[][] dp) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1;
        if (b <= 0) return 0;
        if (dp[a][b] > 0) return dp[a][b];
        dp[a][b] = 0.25 * (f(a - 4, b, dp) + f(a - 3, b - 1, dp) + f(a - 2, b - 2, dp) + f(a - 1, b - 3, dp));
        return dp[a][b];
    }
}
