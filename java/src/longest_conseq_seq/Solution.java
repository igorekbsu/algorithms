package longest_conseq_seq;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 2, 0, 1};
        System.out.println(new Solution().longestConsecutive(a));
    }

    public int longestConsecutive(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : a) {
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