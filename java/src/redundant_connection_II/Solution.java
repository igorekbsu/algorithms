package redundant_connection_II;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] edges = {{4, 2}, {1, 5}, {5, 2}, {5, 3}, {2, 4}};
        System.out.println(Arrays.toString(new Solution().findRedundantDirectedConnection(edges)));
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1}, can2 = {-1, -1}, parents = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++)
            if (parents[edges[i][1]] == 0)
                parents[edges[i][1]] = edges[i][0];
            else {
                can1 = new int[]{parents[edges[i][1]], edges[i][1]};
                can2 = new int[]{edges[i][0], edges[i][1]};
                edges[i][1] = 0;
            }
        for (int i = 0; i < edges.length; i++)
            parents[i] = i;
        for (int[] edge : edges) {
            if (edge[1] == 0) continue;
            int child = edge[1], parent = edge[0];
            if (root(parents, parent) == child)
                return can1[0] == -1 ? edge : can1;
            parents[child] = parent;
        }
        return can2;
    }

    int root(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
