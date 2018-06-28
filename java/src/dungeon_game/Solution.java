package dungeon_game;
public class Solution {
    public static void main(String[] args) {
        int[][] d = {
            {1, 0, 4}
        };
        System.out.println(new Solution().calculateMinimumHP(d));
    }

    public int calculateMinimumHP(int[][] d) {
        if (d.length == 0) return 0;
        int n = d.length - 1, m = d[0].length - 1;
        d[n][m] = Math.max(1, 1 - d[n][m]);
        for (int i = n - 1; i >= 0; i--)
            d[i][m] = Math.max(1, d[i + 1][m] - d[i][m]);
        for (int i = m - 1; i >= 0; i--)
            d[n][i] = Math.max(1, d[n][i + 1] - d[n][i]);
        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--)
                d[i][j] = Math.max(1, Math.min(d[i + 1][j], d[i][j + 1]) - d[i][j]);
        return d[0][0];
    }
}
