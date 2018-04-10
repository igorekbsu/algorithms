package image_smoother;
public class Solution {
    public int[][] imageSmoother(int[][] m) {
        int[][] dirs = {{0, -1}, {-1, -1}, {-1, 0}, {1, 1}, {0, 1}, {1, 0}, {-1, 1}, {1, -1}};
        int[][] r = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++) {
                int sum = m[i][j], n = 1;
                for (int[] dir : dirs) {
                    int x = dir[0] + i, y = dir[1] + j;
                    if (x < 0 || x >= m.length || y < 0 || y >= m[0].length) continue;
                    sum += m[x][y];
                    n++;
                }
                r[i][j] = sum / n;
            }
        return r;
    }
}
