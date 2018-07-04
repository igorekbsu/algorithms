package score_after_flipping_matrix;
public class Solution {
    public static void main(String[] args) {
        int[][] m = {
            {0, 0, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 0}
        };
        System.out.println(new Solution().matrixScore(m));
    }

    public int matrixScore(int[][] a) {
        int n = a.length, m = a[0].length, score = (1 << (m - 1)) * n;
        for (int j = 1; j < m; j++) {
            int k = 0;
            for (int[] row : a)
                k += row[0] == row[j] ? 1 : 0;
            score += Math.max(k, n - k) * (1 << (m - j - 1));
        }
        return score;
    }
}
