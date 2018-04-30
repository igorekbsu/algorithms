package subarray_product_less_than_k;
public class Solution {
    public int numSubarrayProductLessThanK(int[] a, int k) {
        if (k == 0) return 0;
        int mult = 1, r = 0;
        for (int lo = 0, hi = 0; hi < a.length; hi++) {
            mult *= a[hi];
            while (lo <= hi && mult >= k)
                mult /= a[lo++];
            r += hi - lo + 1;
        }
        return r;
    }
}
