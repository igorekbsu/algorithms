package min_subarray_len;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
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
}