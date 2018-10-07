package smallest_range_II;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().smallestRangeII(new int[]{1, 7, 10}, 2));
    }

    public int smallestRangeII(int[] a, int k) {
        Arrays.sort(a);
        int n = a.length, max = a[n - 1], min = a[0], r = max - min;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, a[i] + 2 * k);
            min = Math.min(a[i + 1], a[0] + 2 * k);
            r = Math.min(r, max - min);
        }
        return r;
    }
}
