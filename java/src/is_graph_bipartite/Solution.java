package is_graph_bipartite;
public class Solution {
    public boolean isBipartite(int[][] g) {
        int[] colors = new int[g.length];
        for (int i = 0; i < g.length; i++)
            if (colors[i] == 0)
                if (!dfs(g, colors, 1, i))
                    return false;
        return true;
    }

    boolean dfs(int[][] g, int[] colors, int color, int u) {
        if (colors[u] != 0)
            return colors[u] == color;
        for (int v : g[u])
            if (!dfs(g, colors, -color, v))
                return false;
        return true;
    }
}
