package reverse_string_II;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcd", 4));
    }

    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int lo = 0; lo < s.length(); ) {
            int hi = lo + k > a.length ? a.length : lo + k;
            int right = hi - 1;
            while (lo < right) {
                char c = a[lo];
                a[lo++] = a[right];
                a[right--] = c;
            }
            lo = hi + k;
        }
        return new String(a);
    }
}
