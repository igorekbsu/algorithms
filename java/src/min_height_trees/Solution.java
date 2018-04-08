package min_height_trees;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<>(n);
        for(int i = 0; i < n; i++)
            graph.add(new HashSet<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (graph.get(i).size() <= 1)
                leaves.add(i);
        while (n > 2) {
            n -= leaves.size();
            List<Integer> next = new LinkedList<>();
            for (Integer u : leaves) {
                Integer v = graph.get(u).iterator().next();
                graph.get(v).remove(u);
                if (graph.get(v).size() == 1)
                    next.add(v);
            }
            leaves = next;
        }
        return leaves;
    }
}
