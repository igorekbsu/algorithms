package reverse_int;
public class Solution {
    public int reverse(int x) {
        long r = 0;
        int sign = x >= 0 ? 1 : -1;
        x *= sign;
        while (x > 0) {
            r = 10 * r + x % 10;
            x /= 10;
        }
        r *= sign;
        return r > Integer.MAX_VALUE || r < Integer.MIN_VALUE ? 0 : (int) r;
    }
}
