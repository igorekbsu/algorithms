package search_2d_matrix_II;
public class Solution {
    public boolean searchMatrix(int[][] m, int t) {
        if (m.length == 0) return false;
        for (int r = 0, c = m[0].length - 1; r < m.length && c >= 0; )
            if (m[r][c] == t)
                return true;
            else if (m[r][c] < t)
                c--;
            else r++;
        return false;
    }
}
