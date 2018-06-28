package k_th_smallest_number_in_mult_table;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthNumber(2, 4, 7));
    }

    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int c = count(mid, m, n);
            if (c >= k)
                hi = mid;
            else lo = mid + 1;
        }
        return hi;
    }

    int count(int v, int m, int n) {
        int r = 0;
        for (int i = 1; i <= m; i++)
            r += Math.min(v / i, n);
        return r;
    }
}
