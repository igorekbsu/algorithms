package smallest_good_base;
public class Solution {
    public String smallestGoodBase(String s) {
        long n = Long.valueOf(s);
        for (int m = (int) (Math.log(n + 1) / Math.log(2)); m >= 2; m--) {
            long lo = (long) (Math.pow(n + 1, 1.0 / m));
            long hi = (long) (Math.pow(n, 1.0 / (m - 1)));
            while (lo <= hi) {
                long mid = lo + ((hi - lo) >> 1), f = 0L;
                for (int i = 0; i < m; i++, f = f * mid + 1) ;
                if (n == f)
                    return String.valueOf(mid);
                else if (n < f)
                    hi = mid - 1;
                else lo = mid + 1;
            }
        }
        return String.valueOf(n - 1);
    }
}
