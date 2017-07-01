package range_sum;
public class Solution {
    public static void main(String[] args) {
        int[][] m = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix n = new NumMatrix(m);
        System.out.println(n.sumRegion(2, 1, 4, 3));
        System.out.println(n.sumRegion(1, 1, 2, 2));
    }

    static class NumMatrix {
        int[][] m;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            m = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[0].length; j++)
                    m[i + 1][j + 1] = m[i][j + 1] + m[i + 1][j] - m[i][j] + matrix[i][j];
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if(m == null)return 0;
           return m[row2 + 1][col2 + 1] - m[row1][col2 + 1] - m[row2 + 1][col1] + m[row1][col1];
        }
    }
}
