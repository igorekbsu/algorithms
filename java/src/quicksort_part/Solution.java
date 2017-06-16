package quicksort_part;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 5, -2, 7, 4, 6, 3, 0};
        new Solution().partition(a);
        System.out.println(Arrays.toString(a));
    }

    void partition(int[] a) {
        int p = a[a.length - 1];
        int i = 0;
        for (int k = 0; k < a.length - 1; k++)
            if (a[k] <= p)
                swap(a, i++, k);
        swap(a, i, a.length - 1);
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
