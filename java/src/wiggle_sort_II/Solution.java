package wiggle_sort_II;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 5, 1, 1, 6, 4};
        new Solution().wiggleSort(a);
        System.out.println(Arrays.toString(a));
    }

    public void wiggleSort(int[] a) {
        int n = a.length, m = (n + 1) >> 1;
        int[] copy = Arrays.copyOf(a, n);
        Arrays.sort(copy);
        for (int i = m - 1, j = 0; i >= 0; i--, j += 2)
            a[j] = copy[i];
        for (int i = n - 1, j = 1; i >= m; i--, j += 2)
            a[j] = copy[i];
    }
}
