package max_rectangle;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        char[][] m = {
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}};
//        char[][] m = {
//                {'0', '0', '0', '1', '0', '0', '0'},
//                {'0', '0', '1', '1', '1', '0', '0'},
//                {'0', '1', '1', '1', '1', '1', '0'}};
        char[][] m = {{'1'}};
        System.out.println(new Solution().maximalRectangle(m));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix[0].length;
        int[] left = new int[n], right = new int[n], height = new int[n];
        Arrays.fill(right, n);
        int maxA = 0;
        for (char[] row : matrix) {
            for (int j = 0; j < n; j++)
                if (row[j] == '1')
                    height[j]++;
                else height[j] = 0;
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++)  // compute left (from left to right)
                if (row[j] == '1')
                    left[j] = Math.max(left[j], curLeft);
                else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            // compute right (from right to left)
            for (int j = n - 1; j >= 0; j--)
                if (row[j] == '1')
                    right[j] = Math.min(right[j], curRight);
                else {
                    right[j] = n;
                    curRight = j;
                }
            // compute the area of rectangle (can do this from either side)
            for (int j = 0; j < n; j++)
                maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
        }
        return maxA;
    }
}
