package comp;

public class Solution {
    public int projectionArea(int[][] grid) {
        int x = 0, y = 0, z = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++) {
                x = Math.max(x, grid[i][j]);
                y = Math.max(y, grid[j][i]);
                if (grid[i][j] > 0)
                    z++;
            }
        return x + y + z;
    }
}
