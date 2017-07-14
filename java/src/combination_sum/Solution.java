package combination_sum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7};
        System.out.println(new Solution().combinationSum4(a, 7));
        System.out.println(new Solution().combinationSum(a, 7));
    }

    public int combinationSum4(int[] nums, int target) {
        return combinationSum4(nums, target, new HashMap<>());
    }

    int combinationSum4(int[] nums, int target, Map<Integer, Integer> cache) {
        if (target == 0)
            return 1;
        if (cache.containsKey(target))
            return cache.get(target);
        int count = 0;
        for (int num : nums)
            if (target >= num)
                count += combinationSum4(nums, target - num, cache);
        cache.put(target, count);
        return count;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> r = new LinkedList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<>(), r);
        return r;
    }

    void combinationSum(int[] a, int t, int start, List<Integer> list, List<List<Integer>> r) {
        if (t == 0)
            r.add(new ArrayList<>(list));
        for (int i = start; i < a.length && a[i] <= t; i++) {
            list.add(a[i]);
            combinationSum(a, t - a[i], i, list, r);
            list.remove(list.size() - 1);
        }
    }
}
