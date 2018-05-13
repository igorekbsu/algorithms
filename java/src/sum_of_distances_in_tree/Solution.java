package sum_of_distances_in_tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        System.out.println(Arrays.toString(new Solution().sumOfDistancesInTree(6, edges)));
    }

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        int[] r = new int[N], count = new int[N];
        for (int i = 0; i < N; ++i)
            tree.add(new LinkedList<>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        dfs(0, new HashSet<>(), count, r, tree);
        dfs2(0, new HashSet<>(), count, r, tree, N);
        return r;
    }

    void dfs(int root, Set<Integer> seen, int[] count, int[] r, List<List<Integer>> tree) {
        seen.add(root);
        for (int i : tree.get(root))
            if (!seen.contains(i)) {
                dfs(i, seen, count, r, tree);
                count[root] += count[i];
                r[root] += r[i] + count[i];
            }
        count[root]++;
    }

    void dfs2(int root, Set<Integer> seen, int[] count, int[] r, List<List<Integer>> tree, int N) {
        seen.add(root);
        for (int i : tree.get(root))
            if (!seen.contains(i)) {
                r[i] = r[root] - count[i] + N - count[i];
                dfs2(i, seen, count, r, tree, N);
            }
    }
}
