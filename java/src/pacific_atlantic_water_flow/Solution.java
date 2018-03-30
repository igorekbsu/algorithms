package pacific_atlantic_water_flow;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> r = new LinkedList<>();
        if (matrix.length == 0) return r;
        int dir[] = {-1, 0, 1, 0, -1}, n = matrix.length, m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m], atlantic = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, 0, 0, i, dir);
            dfs(matrix, atlantic, 0, n - 1, i, dir);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, 0, i, 0, dir);
            dfs(matrix, atlantic, 0, i, m - 1, dir);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (pacific[i][j] && atlantic[i][j])
                    r.add(new int[]{i, j});
        return r;
    }

    void dfs(int[][] m, boolean[][] visited, int h, int i, int j, int[] dir) {
        if (i < 0 || i == m.length || j < 0 || j == m[0].length || visited[i][j] || m[i][j] < h)
            return;
        visited[i][j] = true;
        for (int d = 1; d < dir.length; d++)
            dfs(m, visited, m[i][j], i + dir[d - 1], j + dir[d], dir);
    }
}
