package is_graph_bipartite;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public boolean isBipartite(int[][] g) {
        int[] colors = new int[g.length];
        for (int i = 0; i < g.length; i++)
            if (colors[i] == 0) {
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                colors[i] = 1;
                while (!q.isEmpty()) {
                    Integer v = q.poll();
                    for (int adjacent : g[v])
                        if (colors[adjacent] == colors[v])
                            return false;
                        else if (colors[adjacent] == 0) {
                            q.add(adjacent);
                            colors[adjacent] = -colors[v];
                        }
                }
            }
        return true;
    }
}
