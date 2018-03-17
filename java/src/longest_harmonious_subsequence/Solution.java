package longest_harmonious_subsequence;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findLHS(new int[]{1, 2, 1, 3, 0, 0, 2, 2, 1, 3, 3}));
    }

    public int findLHS(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums)
            m.put(num, m.getOrDefault(num, 0) + 1);
        int max = 0;
        for (Integer n : m.keySet())
            if (m.containsKey(n + 1))
                max = Math.max(max, m.get(n) + m.get(n + 1));
        return max;
    }
}
