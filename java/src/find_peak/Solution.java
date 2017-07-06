package find_peak;
public class Solution {
    public int findPeakElement1(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i - 1])
                return i - 1;
        return a.length - 1;
    }

    public int findPeakElement(int[] a) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int m1 = (hi - lo) / 2 + lo;
            int m2 = m1 + 1;
            if (a[m1] < a[m2]) {
                lo = m2;
            } else
                hi = m1;
        }
        return lo;
    }
}
