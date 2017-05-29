package div;
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(2147483647, 2));
    }

    public int divide(int num, int div) {
        if (num == Integer.MIN_VALUE && div == -1) return Integer.MAX_VALUE;
        int sign = 1;
        if ((num > 0 && div < 0) || (num < 0 && div > 0)) sign = -1;
        long n = Math.abs((long) num);
        long d = Math.abs((long) div);
        if (d == 1) return (int) (n * sign);
        int result = 0;
        while (n >= d) {
            int r = 1;
            long sum = d;
            while (n >= (sum + sum)) {
                r <<= 1;
                sum += sum;
            }
            result += r;
            n -= sum;
        }
        return sign * result;
    }
}