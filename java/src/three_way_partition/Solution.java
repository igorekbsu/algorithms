package three_way_partition;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {-1, -3, 5, 0, 0, 7, 0, -5};
        new Solution().sort(a, 0);
        System.out.println(Arrays.toString(a));
    }

    void sort(int[] a, int med) {
        int lo = 0, c = 0, hi = a.length - 1;
        while (c < hi) {
            if (a[c] < med) {
                swap(a, lo, c);
                lo++; c++;
            } else if (a[c] > med) {
                swap(a, c, hi);
                hi--;
            } else {
                c++;
            }
        }
    }

    void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
