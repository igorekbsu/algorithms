package continuous_subarray_sum;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] a = {23, 2, 4, 6, 7};
        System.out.println(new Solution().checkSubarraySum(a, 6));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cs = 0;
        for (int i = 0; i < nums.length; i++) {
            cs += nums[i];
            if (k != 0) cs %= k;
            Integer prev = map.get(cs);
            if (prev != null) {
                if (i - prev > 1) return true;
            } else map.put(cs, i);
        }
        return false;

    }
}
