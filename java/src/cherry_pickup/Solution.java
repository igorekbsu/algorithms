package cherry_pickup;
import java.util.Arrays;

public class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid.length][grid.length];
        for (int[][] layer : dp)
            for (int[] row : layer)
                Arrays.fill(row, Integer.MIN_VALUE);
        return Math.max(0, pickup(0, 0, 0, grid, dp));
    }

    public int pickup(int r1, int c1, int c2, int[][] grid, int[][][] dp) {
        int r2 = r1 + c1 - c2, N = dp.length;
        if (N == r1 || N == r2 || N == c1 || N == c2 || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return -999_999;
        else if (r1 == N - 1 && c1 == N - 1)
            return grid[r1][c1];
        else if (dp[r1][c1][c2] != Integer.MIN_VALUE)
            return dp[r1][c1][c2];
        else {
            int r = grid[r1][c1];
            if (c1 != c2 && r1 != r2)
                r += grid[r2][c2];
            r += Math.max(Math.max(pickup(r1, c1 + 1, c2 + 1, grid, dp), pickup(r1 + 1, c1, c2 + 1, grid, dp)),
                Math.max(pickup(r1, c1 + 1, c2, grid, dp), pickup(r1 + 1, c1, c2, grid, dp)));
            dp[r1][c1][c2] = r;
            return r;
        }
    }
}
