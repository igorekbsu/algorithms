package search_in_rotated_array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
    }

    public int search(int[] a, int target) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (a[mid] > a[hi])
                lo = mid + 1;
            else hi = mid;
        }
        int r = Arrays.binarySearch(a, lo, hi + 1, target);
        return r >= 0 ? r : -1;
    }
}
