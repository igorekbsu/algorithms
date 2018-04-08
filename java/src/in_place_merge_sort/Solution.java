package in_place_merge_sort;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {0, -2, 5, 9, 1, 0};
        new Solution().sort(a);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    void sort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int m = (lo + hi) / 2;
            sort(a, lo, m);
            sort(a, m + 1, hi);
            for (int i = m + 1; i <= hi; i++) {
                int p = a[i], j = i - 1;
                while (j >= 0 && a[j] > p)
                    a[j + 1] = a[j--];
                a[j + 1] = p;
            }
        }
    }
}
