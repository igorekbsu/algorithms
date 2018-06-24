package product_of_array_except_self;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public int[] productExceptSelf(int[] a) {
        int[] p = new int[a.length];
        p[0] = 1;
        for (int i = 0; i < a.length - 1; i++)
            p[i + 1] = p[i] * a[i];
        for (int i = a.length - 1, r = 1; i >= 0; i--) {
            p[i] *= r;
            r *= a[i];
        }
        return p;
    }
}
