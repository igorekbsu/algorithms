package max_sum_circular_subarray;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
    }

    public int maxSubarraySumCircular(int[] a) {
        int max = a[0], min = a[0], total = a[0], curMax = a[0], curMin = a[0];
        for (int i = 1; i < a.length; i++) {
            curMax = Math.max(curMax + a[i], a[i]);
            max = Math.max(max, curMax);
            curMin = Math.min(curMin + a[i], a[i]);
            min = Math.min(min, curMin);
            total += a[i];
        }
        return max > 0 ? Math.max(max, total - min) : max;
    }
}
