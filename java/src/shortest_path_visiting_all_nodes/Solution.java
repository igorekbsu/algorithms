package shortest_path_visiting_all_nodes;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestPathLength(int[][] g) {
        int n = g.length, dp[][] = new int[1 << n][n];
        Queue<State> q = new LinkedList<>();
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        for (int u = 0; u < g.length; u++) {
            dp[1 << u][u] = 0;
            q.offer(new State(1 << u, u));
        }
        while (!q.isEmpty()) {
            State state = q.poll();
            int d = dp[state.path][state.curr];
            if (state.path == (1 << n) - 1)
                return d;
            for (int v : g[state.curr]) {
                int path = state.path | (1 << v);
                if (d + 1 < dp[path][v]) {
                    dp[path][v] = d + 1;
                    q.offer(new State(path, v));
                }
            }
        }
        return -1;
    }

    class State {
        int path, curr;

        public State(int path, int curr) { this.path = path; this.curr = curr;}
    }
}
