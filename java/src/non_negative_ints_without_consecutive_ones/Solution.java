package non_negative_ints_without_consecutive_ones;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findIntegers(8));
    }

    public int findIntegers(int num) {
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < 32; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        int sum = 0;
        int prev = 0;
        for (int i = 30; i >= 0; i--) {
            if ((num & (1 << i)) > 0) {
                sum += f[i];
                if (prev == 1) {
                    sum--;
                    break;
                }
                prev = 1;
            } else {
                prev = 0;
            }

        }
        return sum + 1;
    }
}
