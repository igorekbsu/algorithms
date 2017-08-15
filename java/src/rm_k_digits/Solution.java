package rm_k_digits;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removeKdigits("1432219", 3));
        System.out.println(new Solution().removeKdigits("10200", 1));
        System.out.println(new Solution().removeKdigits("10", 2));
    }

    public String removeKdigits(String num, int k) {
        int i;
        StringBuilder s = new StringBuilder(num);
        while (k-- > 0) {
            for (i = 0; i < s.length() - 1 && s.charAt(i) <= s.charAt(i + 1); i++) ;
            s.deleteCharAt(i);
        }
        for (i = 0; i < s.length() && s.charAt(i) == '0'; i++) ;
        return i == s.length() ? "0" : s.substring(i);
    }
}
