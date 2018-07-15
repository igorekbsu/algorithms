package search_2d_matrix;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        input[][] m = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };
        int[][] m = {
                {1}
        };
        System.out.println(new Solution().searchMatrix(m, 1));
    }

    public boolean searchMatrix1(int[][] m, int t) {
        if (m.length == 0 || m[0].length == 0 || t < m[0][0] || t > m[m.length - 1][m[0].length - 1]) return false;
        int row = 0, col = m[0].length - 1;
        while (row < m.length && col >= 0) {
            if (m[row][col] == t)
                return true;
            else if (t < m[row][col])
                col--;
            else row++;
        }
        return false;
    }

    public boolean searchMatrix(int[][] m, int t) {
        if (m.length == 0 || m[0].length == 0 || t < m[0][0] || t > m[m.length - 1][m[0].length - 1]) return false;
        int lo = 0, hi = m.length - 1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (m[mid][0] == t) return true;
            else if (t > m[mid][0]) lo = mid + 1;
            else hi = mid - 1;
        }
        if (lo > 0) lo = lo - 1;
        return Arrays.binarySearch(m[lo], t) >= 0;
    }
}