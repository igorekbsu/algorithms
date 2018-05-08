package h_index_II;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().hIndex(new int[]{0, 1, 3, 5, 6}));
    }

    public int hIndex(int[] c) {
        int n = c.length, lo = 0, hi = n - 1;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (c[m] < n - m)
                lo = m + 1;
            else hi = m;
        }
        return lo < n && c[lo] >= n - lo ? n - lo : 0;
    }
}
