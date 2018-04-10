package graph_valid_tree;
import java.util.Arrays;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] p = new int[n];
        Arrays.fill(p, -1);
        for (int[] edge : edges) {
            int x = find(p, edge[0]), y = find(p, edge[1]);
            if (x == y) return false;
            p[x] = y;
        }
        return edges.length + 1 == n;
    }

    int find(int[] p, int i) {
        if (p[i] != -1) {
            p[i] = find(p, p[i]);
            i = p[i];
        }
        return i;
    }
}
