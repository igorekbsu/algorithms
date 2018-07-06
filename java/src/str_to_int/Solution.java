package str_to_int;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi(Integer.MIN_VALUE + 1 + ""));
    }

    public int myAtoi(String str) {
        int i = 0, sign = 1, r = 0;
        char[] a = str.toCharArray();
        while (i < a.length && a[i] == ' ')
            i++;
        if (i >= a.length) return 0;
        if (a[i] == '-' || a[i] == '+')
            sign = a[i++] == '-' ? -1 : 1;
        while (i < a.length && Character.isDigit(a[i]))
            if (r > Integer.MAX_VALUE / 10 || (r == Integer.MAX_VALUE / 10 && a[i] > '7'))
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            else r = 10 * r + a[i++] - '0';
        return sign * r;
    }
}
