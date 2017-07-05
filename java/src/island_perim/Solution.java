package island_perim;
public class Solution {
    int p;

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1) {
                    visit(grid, i, j);
                    return p;
                }
        return p;
    }

    void visit(int[][] g, int i, int j) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] == 0) {
            p++;
            return;
        }
        if (g[i][j] == -1) return;
        g[i][j] = -1;
        visit(g, i + 1, j);
        visit(g, i, j + 1);
        visit(g, i - 1, j);
        visit(g, i, j - 1);
    }
}
