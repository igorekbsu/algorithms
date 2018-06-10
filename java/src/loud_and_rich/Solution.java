package loud_and_rich;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < quiet.length; i++)
            m.put(i, new LinkedList<>());
        for (int[] r : richer)
            m.get(r[1]).add(r[0]);
        int[] r = new int[quiet.length];
        Arrays.fill(r, -1);
        for (int i = 0; i < r.length; i++)
            dfs(i, quiet, m, r);
        return r;
    }

    int dfs(int i, int[] quiet, Map<Integer, List<Integer>> m, int[] r) {
        if (r[i] >= 0) return r[i];
        r[i] = i;
        for (int j : m.get(i))
            if (quiet[r[i]] > quiet[dfs(j, quiet, m, r)])
                r[i] = r[j];
        return r[i];
    }
}
