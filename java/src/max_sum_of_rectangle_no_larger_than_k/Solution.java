package max_sum_of_rectangle_no_larger_than_k;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        int[][] m = {
            {-1},
            {1},
            {2},
            {10}
        };
        System.out.println(new Solution().maxSumSubmatrix(m, 3));

    }

    public int maxSumSubmatrix(int[][] a, int k) {
        if (a[0].length == 0) return 0;
        for (int r = 0; r < a.length; r++)
            for (int c = 0; c < a[0].length; c++) {
                if (r - 1 >= 0)
                    a[r][c] += a[r - 1][c];
                if (c - 1 >= 0)
                    a[r][c] += a[r][c - 1];
                if (r - 1 >= 0 && c - 1 >= 0)
                    a[r][c] -= a[r - 1][c - 1];
            }
        int max = Integer.MIN_VALUE;
        for (int c1 = 0; c1 < a[0].length; c1++)
            for (int c2 = c1; c2 < a[0].length; c2++) {
                TreeSet<Integer> s = new TreeSet<>();
                s.add(0);
                for (int r = 0; r < a.length; r++) {
                    int area = a[r][c2];
                    if (c1 - 1 >= 0)
                        area -= a[r][c1];
                    Integer b = s.ceiling(area - k);
                    if (b != null)
                        max = Math.max(max, area - b);
                    s.add(area);
                }
            }
        return max;
    }
}
