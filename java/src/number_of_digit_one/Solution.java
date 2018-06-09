package number_of_digit_one;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countDigitOne(110));
    }
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int r = 0;
        for (int left = n, right = 0, m = 1; left > 0; ) {
            int digit = left % 10;
            r += (left = left / 10) * m;
            if (digit == 1)
                r += right + 1;
            else if (digit > 1) r += m;
            right = digit * m + right;
            m *= 10;
        }
        return r;
    }
}
