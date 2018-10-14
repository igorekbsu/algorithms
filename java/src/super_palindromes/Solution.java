package super_palindromes;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().superpalindromesInRange("4", "10"));
    }

    public int superpalindromesInRange(String sL, String sR) {
        long L = Long.valueOf(sL), R = Long.valueOf(sR);
        int LIM = 100_000, r = 0;
        for (int d = 0; d <= 1; d++)
            for (int k = 1; k < LIM; k++) {
                StringBuilder sb = new StringBuilder(Integer.toString(k));
                for (int i = sb.length() - 1 - d; i >= 0; i--)
                    sb.append(sb.charAt(i));
                long v = Long.valueOf(sb.toString());
                v *= v;
                if (v > R) break;
                if (v >= L && isPalindrome(v)) r++;
            }
        return r;
    }

    boolean isPalindrome(long x) {
        long reversed = 0, y = x;
        while (y > 0) {
            reversed = 10 * reversed + y % 10;
            y /= 10;
        }
        return x == reversed;
    }
}
