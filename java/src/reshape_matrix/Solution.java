package reshape_matrix;
public class Solution {
    public static void main(String[] args) {

    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums[0].length == 0) return nums;
        int n = nums.length, m = nums[0].length;
        if (n * m != r * c) return nums;
        int[][] res = new int[r][c];
        int a = 0, b = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = nums[a][b++];
                if (b >= m) {
                    b = 0;
                    a++;
                }
            }
        }
        return res;
    }
}
