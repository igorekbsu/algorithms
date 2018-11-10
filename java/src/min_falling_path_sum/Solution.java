package min_falling_path_sum;
public class Solution {
    public int minFallingPathSum(int[][] a) {
        for (int i = a.length - 2; i >= 0; i--) {
            for (int c = 0; c < a.length; c++) {
                int min = a[i + 1][c];
                if (c > 0)
                    min = Math.min(min, a[i + 1][c - 1]);
                if (c < a.length - 1)
                    min = Math.min(min, a[i + 1][c + 1]);
                a[i][c] += min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int val : a[0])
            min = Math.min(val, min);
        return min;
    }
}
