package combinations;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> r = new LinkedList<>();
        dfs(0, new ArrayList<>(k), r, k, n);
        return r;
    }

    void dfs(int i, List<Integer> curr, List<List<Integer>> r, int k, int n) {
        if (curr.size() == k)
            r.add(new ArrayList<>(curr));
        else for (int j = i; j < n; j++) {
            curr.add(j + 1);
            dfs(j + 1, curr, r, k, n);
            curr.remove(curr.size() - 1);
        }
    }
}
