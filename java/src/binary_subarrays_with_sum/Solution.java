package binary_subarrays_with_sum;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numSubarraysWithSum(new int[]{1, 0, 0, 1, 1, 0, 0, 1, 0, 1}, 2));
    }

    public int numSubarraysWithSum(int[] a, int s) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        int cs = 0, r = 0;
        for (int n : a) {
            cs += n;
            r += m.getOrDefault(cs - s, 0);
            m.put(cs, m.getOrDefault(cs, 0) + 1);
        }
        return r;
    }
}
