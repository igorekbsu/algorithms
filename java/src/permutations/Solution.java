package permutations;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] a) {
        List<List<Integer>> r = new LinkedList<>();
        List<Integer> curr = new ArrayList<>(a.length);
        boolean[] used = new boolean[a.length];
        dfs(0, a, used, curr, r);
        return r;
    }

    void dfs(int i, int[] a, boolean[] used, List<Integer> curr, List<List<Integer>> r) {
        if (curr.size() == a.length)
            r.add(new ArrayList<>(curr));
        else for (int j = 0; j < a.length; j++)
            if (!used[j]) {
                curr.add(a[j]);
                used[j] = true;
                dfs(j + 1, a, used, curr, r);
                used[j] = false;
                curr.remove(curr.size() - 1);
            }
    }
}
