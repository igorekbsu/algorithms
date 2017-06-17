package subarray;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    //max len such as sum=k
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] cs = new int[nums.length + 1];
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            cs[i + 1] = cs[i] + nums[i];
            map.put(cs[i + 1], i + 1);
        }
        int max = 0;
        for (int i = 0; i < cs.length; i++) {
            Integer s2i = map.get(cs[i] + k);
            if (s2i != null)
                max = Math.max(max, s2i - i);
        }
        return max;
    }

    public int minSubArrayLen(int s, int[] a) {
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < a.length) {
            sum += a[j++];
            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    //max product
    int maxProduct(int[] nums) {
        int r = nums[0];
        for (int i = 1, max = r, min = r; i < nums.length; i++) {
            if (nums[i] < 0) {
                int t = max;
                max = min;
                min = t;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            r = Math.max(r, max);
        }
        return r;
    }
}
