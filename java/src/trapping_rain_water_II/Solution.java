package trapping_rain_water_II;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[][] h = {
            {1, 4, 3, 1, 3, 2},
            {3, 2, 1, 3, 2, 4},
            {2, 3, 3, 2, 3, 1}
        };
        System.out.println(new Solution().trapRainWater(h));
    }

    public int trapRainWater(int[][] heights) {
        if (heights.length == 0)
            return 0;
        int r = 0, n = heights.length, m = heights[0].length, dir[] = {-1, 0, 1, 0, -1};
        boolean[][] seen = new boolean[n][m];
        PriorityQueue<Cell> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    seen[i][j] = true;
                    q.offer(new Cell(i, j, heights[i][j]));
                }
        while (!q.isEmpty()) {
            Cell cell = q.poll();
            for (int i = 1; i < dir.length; i++) {
                int row = cell.r + dir[i - 1], col = cell.c + dir[i];
                if (0 <= row && row < n && 0 <= col && col < m && !seen[row][col]) {
                    r += Math.max(0, cell.h - heights[row][col]);
                    q.offer(new Cell(row, col, Math.max(cell.h, heights[row][col])));
                    seen[row][col] = true;
                }
            }
        }
        return r;
    }

    class Cell implements Comparable<Cell> {
        final int r, c, h;

        Cell(int row, int col, int height) {
            r = row; c = col; h = height;
        }

        @Override public int compareTo(Cell o) { return h - o.h;}
    }
}
