package valid_triangle_number;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {2, 2, 3, 4};
        System.out.println(new Solution().triangleNumber(a));
    }

    public int triangleNumber(int[] a) {
        Arrays.sort(a);
        int r = 0;
        for (int i = a.length - 1; i > 0; i--) {
            int lo = 0, hi = i - 1;
            while (lo < hi)
                if (a[lo] + a[hi] > a[i]) {
                    r += hi - lo;
                    hi--;
                } else lo++;
        }
        return r;
    }
}
