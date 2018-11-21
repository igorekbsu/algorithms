package di_string_match;
public class Solution {
    public int[] diStringMatch(String s) {
        int lo = 0, hi = s.length(), r[] = new int[hi + 1];
        for (int i = 0; i < r.length - 1; i++)
            r[i] = s.charAt(i) == 'I' ? lo++ : hi--;
        r[r.length - 1] = hi;
        return r;
    }
}
