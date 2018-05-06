package permutations_II;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] a) {
        List<List<Integer>> r = new LinkedList<>();
        Arrays.sort(a);
        boolean[] used = new boolean[a.length];
        List<Integer> curr = new ArrayList<>(a.length);
        dfs(a, used, curr, r);
        return r;
    }

    void dfs(int[] a, boolean[] used, List<Integer> curr, List<List<Integer>> r) {
        if (curr.size() == a.length)
            r.add(new ArrayList<>(curr));
        else for (int i = 0; i < a.length; i++) {
            if (used[i]) continue;
            if (i > 0 && !used[i - 1] && a[i - 1] == a[i]) continue;
            used[i] = true;
            curr.add(a[i]);
            dfs(a, used, curr, r);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}
