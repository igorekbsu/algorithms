package longest_consecutive_sequence;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int r = 0;
        for (int n : nums)
            if (!m.containsKey(n)) {
                int left = m.getOrDefault(n - 1, 0);
                int right = m.getOrDefault(n + 1, 0);
                int len = left + right + 1;
                r = Math.max(r, len);
                m.put(n - left, len);
                m.put(n + right, len);
                m.put(n, len);
            }
        return r;
    }
}
