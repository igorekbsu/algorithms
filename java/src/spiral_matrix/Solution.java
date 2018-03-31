package spiral_matrix;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        if (m.length == 0) return new ArrayList<>();
        List<Integer> r = new ArrayList<>(m.length * m[0].length);
        int lo = 0, hi = m.length - 1, left = -1, right = m[0].length - 1;
        while (lo <= hi && ++left <= right) {
            for (int i = left; i <= right; i++)
                r.add(m[lo][i]);
            for (int i = ++lo; i <= hi; i++)
                r.add(m[i][right]);
            if (lo > hi || left > --right) break;
            for (int i = right; i >= left; i--)
                r.add(m[hi][i]);
            for (int i = --hi; i >= lo; i--)
                r.add(m[i][left]);
        }
        return r;
    }
}
