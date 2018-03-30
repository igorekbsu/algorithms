package longest_increasing_path_in_matrix;
public class Solution {
    public int longestIncreasingPath(int[][] m) {
        if (m.length == 0) return 0;
        int dirs[] = {-1, 0, 1, 0, -1}, max = 1, cache[][] = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                max = Math.max(max, dfs(m, i, j, dirs, cache));
        return max;
    }

    int dfs(int[][] m, int i, int j, int[] dirs, int[][] cache) {
        if (cache[i][j] > 0) return cache[i][j];
        int max = 1;
        for (int d = 1; d < dirs.length; d++) {
            int x = i + dirs[d - 1], y = j + dirs[d];
            if (x < 0 || x == m.length || y < 0 || y == m[0].length || m[x][y] <= m[i][j]) continue;
            max = Math.max(max, 1 + dfs(m, x, y, dirs, cache));
        }
        cache[i][j] = max;
        return max;
    }
}
