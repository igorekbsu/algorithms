package fenwick;
public class Solution {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        NumMatrix m = new NumMatrix(a);
        System.out.println(m.sumRegion(1, 0, 1, 0));

    }

    static class NumArray {
        final int[] a;
        final int[] bit;

        public NumArray(int[] nums) {
            a = nums;
            bit = new int[a.length + 1];
            for (int i = 0; i < a.length; i++)
                init(i, a[i]);
        }

        int sum(int i) {
            int sum = 0;
            for (int j = i + 1; j > 0; j -= j & (-j))
                sum += bit[j];
            return sum;
        }

        void init(int i, int d) {
            for (int j = i + 1; j <= a.length; j += j & (-j))
                bit[j] += d;
        }

        public void update(int i, int val) {
            int diff = val - a[i];
            a[i] = val;
            init(i, diff);
        }

        public int sumRange(int i, int j) {
            return sum(j) - sum(i - 1);
        }
    }

    static class NumMatrix {
        int[][] tree, nums;
        int m, n;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            m = matrix.length;
            n = matrix[0].length;
            tree = new int[m + 1][n + 1];
            nums = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    update(i, j, matrix[i][j]);
        }

        public void update(int row, int col, int val) {
            if (m == 0 || n == 0) return;
            int delta = val - nums[row][col];
            nums[row][col] = val;
            for (int i = row + 1; i <= m; i += i & (-i))
                for (int j = col + 1; j <= n; j += j & (-j))
                    tree[i][j] += delta;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (m == 0 || n == 0) return 0;
            return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
        }

        public int sum(int row, int col) {
            int sum = 0;
            for (int i = row; i > 0; i -= i & (-i))
                for (int j = col; j > 0; j -= j & (-j))
                    sum += tree[i][j];
            return sum;
        }
    }
}