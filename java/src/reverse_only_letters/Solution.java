package reverse_only_letters;
public class Solution {
    public String reverseOnlyLetters(String s) {
        char[] a = s.toCharArray();
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            while (lo < hi && !Character.isLetter(a[lo]))
                lo++;
            while (hi > lo && !Character.isLetter(a[hi]))
                hi--;
            if (lo < hi) {
                char c = a[lo];
                a[lo] = a[hi];
                a[hi] = c;
                lo++; hi--;
            }
        }
        return new String(a);
    }
}
