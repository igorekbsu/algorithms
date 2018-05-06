package search_in_rotated_sorted_array_II;
public class Solution {
    public boolean search(int[] a, int target) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int m = (lo + hi) >> 1;
            if (a[m] == target) return true;
            if (a[lo] == a[m] && a[hi] == a[m]) {
                ++lo; --hi;
            } else if (a[lo] <= a[m]) {
                if (a[lo] <= target && a[m] > target)
                    hi = m - 1;
                else lo = m + 1;
            } else {
                if (a[m] < target && a[hi] >= target)
                    lo = m + 1;
                else hi = m - 1;
            }
        }
        return false;
    }
}
