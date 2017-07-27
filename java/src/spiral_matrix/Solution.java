package spiral_matrix;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] m = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        System.out.println(new Solution().spiralOrder(m));
    }

    public List<Integer> spiralOrder(int[][] m) {
        List<Integer> spiral = new LinkedList<>();
        if (m.length == 0) return spiral;
        int c1 = 0, c2 = m[0].length - 1, r1 = 0, r2 = m.length - 1;
        while (c1 <= c2 || r1 <= r2) {
            for (int i = c1; i <= c2; i++)
                spiral.add(m[r1][i]);
            r1++;
            if (r1 > r2) break;
            for (int i = r1; i <= r2; i++)
                spiral.add(m[i][c2]);
            c2--;
            if (c2 < c1) break;
            for (int i = c2; i >= c1; i--)
                spiral.add(m[r2][i]);
            r2--;
            if (r1 > r2) break;
            for (int i = r2; i >= r1; i--)
                spiral.add(m[i][c1]);
            c1++;
            if (c1 > c2) break;
        }
        return spiral;
    }
}
