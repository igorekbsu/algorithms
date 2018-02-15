package largest_plus_sign;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().orderOfLargestPlusSign(5, new int[][]{{4, 2}}));

    }

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] g = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(g[i], N);
        for (int[] m : mines)
            g[m[0]][m[1]] = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
                g[i][j] = Math.min(g[i][j], r = (g[i][j] == 0 ? 0 : r + 1));
                g[i][k] = Math.min(g[i][k], l = (g[i][k] == 0 ? 0 : l + 1));
                g[j][i] = Math.min(g[j][i], d = (g[j][i] == 0 ? 0 : d + 1));
                g[k][i] = Math.min(g[k][i], u = (g[k][i] == 0 ? 0 : u + 1));
            }
        int max = 0;
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                max = Math.max(max, g[i][j]);
        return max;
    }
}
