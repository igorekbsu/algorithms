package next_perm;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 3, 3, 0};
        new Solution().nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }

    public void nextPermutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i] <= a[i - 1])
            i--;
        int j = i;
        if (i > 0) {
            while (j < a.length && a[i - 1] < a[j])
                j++;
            swap(a, i - 1, j - 1);
        }
        j = a.length - 1;
        while (i < j)
            swap(a, i++, j--);
    }

    void swap(int[] a, int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }
}
