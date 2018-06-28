package find_peak_element;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findPeakElement(new int[]{1, 2}));
    }

    public int findPeakElement(int[] a) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (a[m] > a[m + 1])
                hi = m;
            else lo = m + 1;
        }
        return hi;
    }
}
