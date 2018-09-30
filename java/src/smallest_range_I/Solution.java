package smallest_range_I;
public class Solution {
    public int smallestRangeI(int[] a, int k) {
        int min = a[0], max = a[0];
        for (int n : a) {
            min = Math.min(n, min);
            max = Math.max(n, max);
        }
        int r = max - min - 2 * k;
        return r >= 0 ? r : 0;
    }
}
