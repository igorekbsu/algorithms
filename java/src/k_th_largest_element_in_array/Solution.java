package k_th_largest_element_in_array;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] a, int k) {
        return findKSmallest(a, 0, a.length - 1, a.length - k, new Random(System.nanoTime()));
    }

    int findKSmallest(int[] a, int lo, int hi, int k, Random r) {
        int idx = lo + r.nextInt(hi - lo + 1);
        swap(a, idx, hi);
        int p = a[hi], left = lo;
        for (int i = lo; i < hi; i++)
            if (a[i] <= p)
                swap(a, left++, i);
        swap(a, left, hi);
        if (left == k) return a[left];
        else if (left < k)
            return findKSmallest(a, left + 1, hi, k, r);
        else return findKSmallest(a, lo, hi - 1, k, r);
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

