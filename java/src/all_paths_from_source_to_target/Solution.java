package all_paths_from_source_to_target;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> r = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(0, graph, path, r);
        return r;
    }

    void dfs(int u, int[][] graph, List<Integer> path, List<List<Integer>> paths) {
        if (u == graph.length - 1)
            paths.add(new ArrayList<>(path));
        else for (int v : graph[u]) {
            path.add(v);
            dfs(v, graph, path, paths);
            path.remove(path.size() - 1);
        }
    }
}
