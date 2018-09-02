package surface_area_of_3d_shapes;
public class Solution {
    public int surfaceArea(int[][] g) {
        int area = 0;
        for (int i = 0; i < g.length; i++)
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] > 0) {
                    area = area + 4 * g[i][j] + 2;
                    if (j > 0)
                        area -= 2 * Math.min(g[i][j - 1], g[i][j]);
                    if (i > 0)
                        area -= 2 * Math.min(g[i - 1][j], g[i][j]);
                }
            }
        return area;
    }
}
