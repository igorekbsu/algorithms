package combination_sum_II;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] a, int target) {
        Arrays.sort(a);
        List<List<Integer>> r = new LinkedList<>();
        sum(a, 0, target, new ArrayList<>(), r);
        return r;
    }

    void sum(int[] a, int i, int target, List<Integer> list, List<List<Integer>> r) {
        if (i > a.length) return;
        if (target == 0)
            r.add(new ArrayList<>(list));
        else for (int j = i; j < a.length; j++)
            if (target - a[j] >= 0) {
                if (j > i && a[j - 1] == a[j]) continue;
                list.add(a[j]);
                sum(a, j + 1, target - a[j], list, r);
                list.remove(list.size() - 1);
            }
    }
}
