package peak_index_in_mountain_array;
public class Solution {
    public int peakIndexInMountainArray(int[] a) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (a[m] < a[m + 1])
                lo = m + 1;
            else hi = m;
        }
        return lo;
    }
}
