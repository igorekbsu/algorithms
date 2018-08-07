package reachable_nodes_in_subdivided_graph;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] edges = {
            {0, 1, 10},
            {0, 2, 1},
            {1, 2, 2},
        };
        System.out.println(new Solution().reachableNodes(edges, 6, 3));
    }

    public int reachableNodes(int[][] edges, int m, int n) {
        int g[][] = new int[n][n], r = 0;
        for (int i = 0; i < n; i++)
            Arrays.fill(g[i], -1);
        for (int[] e : edges) {
            g[e[0]][e[1]] = e[2];
            g[e[1]][e[0]] = e[2];
        }
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        q.offer(new int[]{0, m});
        boolean[] seen = new boolean[n];
        while (!q.isEmpty()) {
            int e[] = q.poll(), u = e[0], dist = e[1];
            if (seen[u]) continue;
            seen[u] = true;
            r++;
            for (int v = 0; v < n; v++)
                if (g[u][v] > -1) {
                    if  (!seen[v] && dist > g[u][v])
                        q.offer(new int[]{v, dist - g[u][v] - 1});
                    g[v][u] -= Math.min(dist, g[u][v]);
                    r += Math.min(dist, g[u][v]);
                }
        }
        return r;
    }
}
