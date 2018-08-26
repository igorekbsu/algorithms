package highest_value_palindrome;
public class Solution {
    public static void main(String[] args) {
        System.out.println(highestValuePalindrome("932239", 6, 2));
    }

    static String highestValuePalindrome(String s, int n, int k) {
        char[] a = s.toCharArray();
        boolean[] mod = new boolean[n];
        for (int lo = 0, hi = n - 1; lo < hi; lo++, hi--)
            if (a[lo] != a[hi]) {
                if (k-- == 0)
                    return "-1";
                mod[hi] = true;
                if (a[lo] > a[hi])
                    a[hi] = a[lo];
                else a[lo] = a[hi];
            }
        for (int lo = 0, hi = n - 1; lo <= hi && k > 0; lo++, hi--)
            if (!(a[lo] == '9' && a[hi] == '9')) {
                int change = mod[hi] || lo == hi ? 1 : 2;
                if (k - change >= 0) {
                    a[lo] = a[hi] = '9';
                    k -= change;
                }
            }
        return new String(a);
    }
}
