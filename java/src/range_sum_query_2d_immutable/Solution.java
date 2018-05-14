package range_sum_query_2d_immutable;
public class Solution {
    class NumMatrix {
        final int[][] cs;

        public NumMatrix(int[][] m) {
            if (m.length == 0)
                cs = new int[0][0];
            else {
                for (int i = 1; i < m.length; i++)
                    m[i][0] += m[i - 1][0];
                for (int i = 1; i < m[0].length; i++)
                    m[0][i] += m[0][i - 1];
                for (int i = 1; i < m.length; i++)
                    for (int j = 1; j < m[0].length; j++)
                        m[i][j] += m[i - 1][j] + m[i][j - 1] - m[i - 1][j - 1];
                cs = m;
            }
        }

        public int sumRegion(int r1, int c1, int r2, int c2) {
            int r = cs[r2][c2];
            if (r1 > 0)
                r = r - cs[r1 - 1][c2];
            if (c1 > 0)
                r = r - cs[r2][c1 - 1];
            if (r1 > 0 && c1 > 0)
                r = r + cs[r1 - 1][c1 - 1];
            return r;
        }
    }
}
