package binary_search;
public class Solution {
    public int search(int[] a, int t) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (a[m] == t) return m;
            else if (a[m] < t)
                lo = m + 1;
            else hi = m - 1;
        }
        return -1;
    }
}
