package bomb_enemy;
public class Solution {
    public static void main(String[] args) {
        char[][] g = new char[5][1];
        g[0] = new char[]{'W'};
        g[1] = new char[]{'E'};
        g[2] = new char[]{'W'};
        g[3] = new char[]{'0'};
        g[4] = new char[]{'E'};
        System.out.println(new Solution().maxKilledEnemies(g));
    }

    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int maxEnemies = 0;
        int[] cols = new int[grid[0].length];
        for (int k = 0; k < grid[0].length; k++)
            cols[k] = colEnemies(grid, k, 0);
        for (int i = 0; i < grid.length; i++) {
            int row = rowEnemies(grid, i, 0);
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0')
                    maxEnemies = Math.max(maxEnemies, cols[j] + row);
                else if (grid[i][j] == 'W') {
                    cols[j] = colEnemies(grid, j, i + 1);
                    row = rowEnemies(grid, i, j + 1);
                }
            }
        }
        return maxEnemies;
    }

    int rowEnemies(char[][] grid, int i, int start) {
        int e = 0;
        for (int k = start; k < grid[0].length; k++)
            if (grid[i][k] == 'W') break;
            else if (grid[i][k] == 'E') e++;
        return e;
    }

    int colEnemies(char[][] grid, int i, int start) {
        int e = 0;
        for (int k = start; k < grid.length; k++)
            if (grid[k][i] == 'W') break;
            else if (grid[k][i] == 'E') e++;
        return e;
    }
}