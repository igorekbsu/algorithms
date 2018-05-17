package beautiful_arrangement_II;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().constructArray(11, 4)));
    }

    public int[] constructArray(int n, int k) {
        int r[] = new int[n], left = 1, right = n;
        for (int i = 0; i < n; i++) {
            r[i] = k % 2 == 0 ? right-- : left++;
            if (k > 1) k--;
        }
        return r;
    }
}
