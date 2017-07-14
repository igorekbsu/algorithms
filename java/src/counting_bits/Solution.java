package counting_bits;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countBits(2)));
    }

    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++)
            f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
