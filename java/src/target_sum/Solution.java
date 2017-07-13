package target_sum;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int S) {
        Map<String, Integer> cache = new HashMap<>();
        return ts(nums, 0, S, cache);
    }

    int ts(int[] nums, int i, long S, Map<String, Integer> cache) {
        if (i == nums.length) {
            if (S == 0) return 1;
            else return 0;
        } else {
            String key = i + "#" + S;
            if (cache.containsKey(key))
                return cache.get(key);
            int count = ts(nums, i + 1, S - nums[i], cache) + ts(nums, i + 1, S + nums[i], cache);
            cache.put(key, count);
            return count;
        }
    }
}
