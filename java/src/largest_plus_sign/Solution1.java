package largest_plus_sign;
public class Solution1 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] m = new int[N][N];
        for (int[] mine : mines)
            m[mine[0]][mine[1]] = 1;
        int max = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (m[i][j] == 0) {
                    int k = 1;
                    for (; k < N; k++)
                        if (i - k >= 0 && i + k < N && j - k >= 0 && j + k < N &&
                            m[i - k][j] == 0 && m[i + k][j] == 0 && m[i][j - k] == 0 && m[i][j + k] == 0)
                            continue;
                        else break;
                    max = Math.max(max, k);
                }
        return max;
    }
}
