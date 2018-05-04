package search_in_rotated_array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public int search(int[] a, int target) {
        if (a.length == 0) return -1;
        int lo = 0, hi = a.length - 1;
        if (a[0] > a[hi]) {
            while (lo < hi) {
                int m = (lo + hi) / 2;
                if (a[lo] < a[m])
                    lo = m;
                else hi = m;
            }
            if (target >= a[0]) {
                hi = lo;
                lo = 0;
            } else {
                lo++;
                hi = a.length - 1;
            }
        }
        int r = Arrays.binarySearch(a, lo, hi + 1, target);
        return r >= 0 ? r : -1;
    }
}
