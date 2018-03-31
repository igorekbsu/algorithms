package spiral_matrix_II;
public class Solution {
    public int[][] generateMatrix(int n) {
        int m[][] = new int[n][n], k = 0, lo = 0, hi = n - 1, left = -1, right = n - 1;
        while (lo <= hi && ++left <= right) {
            for (int i = left; i <= right; i++) m[lo][i] = ++k;
            for (int i = ++lo; i <= hi; i++) m[i][right] = ++k;
            for (int i = --right; i >= left; i--) m[hi][i] = ++k;
            for (int i = --hi; i >= lo; i--) m[i][left] = ++k;
        }
        return m;
    }
}
