package wiggle_sort_II;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 5, 1, 1, 6, 4};
        new Solution().wiggleSort(a);
        System.out.println(Arrays.toString(a));
    }
    public void wiggleSort(int[] a) {
        Arrays.sort(a);
        int m = a.length / 2;
        for (int i = 1, j = m; j < a.length; i += 2, j += 2) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}
