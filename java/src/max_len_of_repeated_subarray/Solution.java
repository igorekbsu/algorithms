package max_len_of_repeated_subarray;
public class Solution {
    public int findLength(int[] a, int[] b) {
        int[][] dp = new int[a.length + 1][b.length + 1];
        int max = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b.length; j++)
                max = Math.max(max, dp[i + 1][j + 1] = a[i] == b[j] ? 1 + dp[i][j] : 0);
        return max;
    }
}
