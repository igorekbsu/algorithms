package nth_digit;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(100));
        System.out.println(new Solution().findNthDigit(3));
    }

    public int findNthDigit(int n) {
        long start = 1, count = 9;
        int m = 1;
        while (n > count * m) {
            n -= count * m;
            count *= 10;
            start *= 10;
            m++;
        }
        String d = String.valueOf(start + (n - 1) / m);
        return d.charAt((n - 1) % m) - '0';
    }
}
