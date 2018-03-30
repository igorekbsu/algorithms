package network_delay_time;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] times = {{1, 2, 1}};
        System.out.println(new Solution().networkDelayTime(times, 2, 1));
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        for (int i = 0; i < N; i++)
            for (int[] e : times) {
                int u = e[0], v = e[1], w = e[2];
                if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + w)
                    dist[v] = dist[u] + w;
            }
        int r = 0;
        for (int i = 1; i <= N; i++)
            r = Math.max(r, dist[i]);
        return r != Integer.MAX_VALUE ? r : -1;
    }
}
