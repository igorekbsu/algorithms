package sparse_matrix_mul;
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length, m = B[0].length;
        int[][] C = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < A[0].length; j++)
                if (A[i][j] != 0) {
                    for (int k = 0; k < m; k++)
                        C[i][k] += A[i][j] * B[j][k];
                }
        return C;
    }
}