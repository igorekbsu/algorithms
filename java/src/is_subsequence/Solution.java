package is_subsequence;
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        char[] a = s.toCharArray();
        for (int j = 0; j < t.length() && i < a.length; j++, i++)
            if ((j = t.indexOf(a[i], j)) == -1) return false;
        return i == a.length;
    }
}
