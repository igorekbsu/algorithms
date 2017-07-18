package longest_increasing_path_in_matrix;
public class Solution {
    public static void main(String[] args) {
        int[][] m = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(new Solution().longestIncreasingPath(m));
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxPath = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        int[] delta = {0, 1, 0, -1, 0};
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                int path = visit(matrix, i, j, cache, delta);
                maxPath = Math.max(path, maxPath);
            }
        return maxPath;
    }

    int visit(int[][] m, int i, int j, int[][] cache, int[] delta) {
        if (cache[i][j] > 0) return cache[i][j];
        int path = 1;
        for (int d = 0; d < 4; d++) {
            int a = i + delta[d], b = j + delta[d + 1];
            if (a >= 0 && a < m.length && b >= 0 && b < m[0].length && m[i][j] > m[a][b])
                path = Math.max(path, 1 + visit(m, a, b, cache, delta));
        }
        cache[i][j] = path;
        return path;
    }
}
