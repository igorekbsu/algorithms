package redundant_connection;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] edges = {{3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}};
        System.out.println(Arrays.toString(new Solution().findRedundantConnection(edges)));
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] p = new int[edges.length + 1];
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (p[a] == 0) p[a] = a;
            if (p[b] == 0) p[b] = b;
            int p1 = find(a, p), p2 = find(b, p);
            if (p1 == p2) return edge;
            p[p1] = p2;
        }
        return null;
    }

    int find(int a, int[] p) {
        if (p[a] != a)
            p[a] = find(p[a], p);
        return p[a];
    }
}
