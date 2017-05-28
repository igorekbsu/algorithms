package spiral;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] m = new int[1][3];
        m[0] = new int[]{1, 2, 3};
        System.out.println(s.spiralOrder(m));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        if (matrix.length == 0) return spiral;
        int x1 = 0, x2 = 0, y1 = matrix.length - 1, y2 = matrix[0].length - 1;
        while (x1 <= y1 && x2 <= y2) {
            for (int i = x2; i <= y2; i++)
                spiral.add(matrix[x1][i]);
            for (int i = x1 + 1; i <= y1; i++)
                spiral.add(matrix[i][y2]);
            if (y1 > x1)
                for (int i = y2 - 1; i >= x2; i--)
                    spiral.add(matrix[y1][i]);
            if (y2 > x2)
                for (int i = y1 - 1; i >= x1 + 1; i--)
                    spiral.add(matrix[i][x2]);
            x1++;
            x2++;
            y1--;
            y2--;
        }
        return spiral;
    }
}
