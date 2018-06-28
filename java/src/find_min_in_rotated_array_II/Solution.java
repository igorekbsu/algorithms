package find_min_in_rotated_array_II;
public class Solution {
    public int findMin(int[] a) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > a[hi])
                lo = mid + 1;
            else if (a[mid] < a[hi])
                hi = mid;
            else hi--;
        }
        return a[lo];
    }
}
