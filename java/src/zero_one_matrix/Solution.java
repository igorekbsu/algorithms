package zero_one_matrix;
public class Solution {
    public static void main(String[] args) {
        int[][] m = {
            {1, 0, 1},
            {1, 0, 1},
            {1, 0, 1}
        };
        new Solution().updateMatrix(m);
    }

    public int[][] updateMatrix(int[][] m) {
        int N = m.length, M = m[0].length;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    m[i][j] = Integer.MAX_VALUE;
                    if (i - 1 >= 0 && m[i - 1][j] != Integer.MAX_VALUE)
                        m[i][j] = Math.min(m[i][j], 1 + m[i - 1][j]);
                    if (j - 1 >= 0 && m[i][j - 1] != Integer.MAX_VALUE)
                        m[i][j] = Math.min(m[i][j], 1 + m[i][j - 1]);
                }
            }
        for (int i = N - 1; i >= 0; i--)
            for (int j = M - 1; j >= 0; j--) {
                if (i + 1 < N && m[i + 1][j] != Integer.MAX_VALUE)
                    m[i][j] = Math.min(m[i][j], 1 + m[i + 1][j]);
                if (j + 1 < M && m[i][j + 1] != Integer.MAX_VALUE)
                    m[i][j] = Math.min(m[i][j], 1 + m[i][j + 1]);
            }
        return m;
    }
}
