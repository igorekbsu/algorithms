package longest_conseq_seq;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int max = 0;
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);
                int len = left + right + 1;
                max = Math.max(max, len);
                map.put(n, len);
                map.put(n - left, len);
                map.put(n + right, len);
            }
        }
        return max;
    }
}