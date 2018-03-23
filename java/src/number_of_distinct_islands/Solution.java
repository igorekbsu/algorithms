package number_of_distinct_islands;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1) {
                    StringBuilder b = new StringBuilder();
                    dfs(grid, i, j, b, 'o');
                    islands.add(b.toString());
                }
        return islands.size();

    }

    void dfs(int[][] g, int i, int j, StringBuilder b, char dir) {
        if (i >= g.length || i < 0 || j >= g[0].length || j < 0 || g[i][j] == 0) return;
        g[i][j] = 0;
        b.append(dir);
        dfs(g, i - 1, j, b, 'u');
        dfs(g, i + 1, j, b, 'd');
        dfs(g, i, j - 1, b, 'l');
        dfs(g, i, j + 1, b, 'r');
        b.append('b');
    }
}
