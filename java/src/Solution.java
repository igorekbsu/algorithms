import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
    }

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;
        Set<Integer> zeroColumns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            boolean zero = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroColumns.add(j);
                    zero = true;
                }
            }
            if (zero) Arrays.fill(matrix[i], 0);
        }
        for (Integer j : zeroColumns) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][j] = 0;
        }
    }
}
