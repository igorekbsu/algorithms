package spiral_matrix_III;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().spiralMatrixIII(1, 4, 0, 0)));
    }

    public int[][] spiralMatrixIII(int R, int C, int r, int c) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}, spiral = new int[R * C][2];
        spiral[0] = new int[]{r, c};
        for (int k = 1, d = 0, len = 0; k < spiral.length; d = (d + 1) % 4) {
            if (d == 0 || d == 2) len++;
            for (int i = 0; i < len; i++) {
                r += dirs[d][0];
                c += dirs[d][1];
                if (r >= 0 && r < R && c >= 0 && c < C)
                    spiral[k++] = new int[]{r, c};
            }
        }
        return spiral;
    }
}
