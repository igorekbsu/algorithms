package reachable_nodes_in_subdivided_graph;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[][] edges = {
            {0, 1, 10},
            {0, 2, 1},
            {1, 2, 2},
        };
        System.out.println(new Solution().reachableNodes(edges, 6, 3));
    }

    public int reachableNodes(int[][] edges, int M, int N) {
        int[][] g = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(g[i], -1);
        for (int[] e : edges) {
            g[e[0]][e[1]] = e[2];
            g[e[1]][e[0]] = e[2];
        }
        int r = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        boolean[] seen = new boolean[N];
        q.offer(new int[]{0, M});
        while (!q.isEmpty()) {
            int cur[] = q.poll(), start = cur[0], move = cur[1];
            if (seen[start])
                continue;
            seen[start] = true;
            r++;
            for (int i = 0; i < N; i++) {
                if (g[start][i] > -1) {
                    if (move > g[start][i] && !seen[i])
                        q.offer(new int[]{i, move - g[start][i] - 1});
                    g[i][start] -= Math.min(move, g[start][i]);
                    r += Math.min(move, g[start][i]);
                }
            }
        }
        return r;
    }
}
