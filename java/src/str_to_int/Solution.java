package str_to_int;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi(Integer.MIN_VALUE + 1 + ""));
    }

    public int myAtoi(String str) {
        int r = 0, sign = 1, i = 0;
        while (i < str.length() && str.charAt(i) == ' ')
            i++;
        if (i == str.length()) return 0;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-') sign = -1;
            i++;
        }
        while (i < str.length() && Character.isDigit(str.charAt(i)))
            if (r > Integer.MAX_VALUE / 10 || (r == Integer.MAX_VALUE / 10 && str.charAt(i) > '7'))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else r = 10 * r + str.charAt(i++) - '0';
        return r * sign;
    }
}
