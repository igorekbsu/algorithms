package max_square;
public class Solution {
    public static void main(String[] args) {
        String[] lines = {
                "1010",
                "1011",
                "1011",
                "1111"
        };
        char[][] m = new char[lines.length][lines[0].length()];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                m[i][j] = lines[i].charAt(j);
        System.out.println(new Solution().maximalSquare(m));
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] prev = new int[matrix[0].length + 1];
        int max = 0, pre = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0')
                    prev[j + 1] = 0;
                else {
                    int up = Math.min(pre, prev[j + 1]);
                    prev[j + 1] = Math.min(prev[j], up) + 1;
                    pre = prev[j + 1];
                    max = Math.max(max, prev[j + 1]);
                }
            }
        return max * max;
    }
}
