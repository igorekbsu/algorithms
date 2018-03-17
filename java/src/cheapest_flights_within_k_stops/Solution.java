package cheapest_flights_within_k_stops;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(new Solution().findCheapestPrice(3, flights, 0, 2, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        long[][] dp = new long[n][K + 1];
        for (long[] a : dp)
            Arrays.fill(a, Integer.MAX_VALUE);
        dp[src][0] = 0;
        for (int[] f : flights)
            if (f[0] == src)
                dp[f[1]][0] = Math.min(dp[f[1]][0], f[2]);
        for (int i = 1; i <= K; i++) {
            for (int k = 0; k < n; k++)
                dp[k][i] = dp[k][i - 1];
            for (int[] f : flights)
                dp[f[1]][i] = Math.min(dp[f[1]][i], dp[f[0]][i - 1] + f[2]);
        }
        return dp[dst][K] == Integer.MAX_VALUE ? -1 : (int) dp[dst][K];
    }
}
