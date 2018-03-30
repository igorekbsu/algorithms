package one_edit_distance;
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenDiff = s.length() - t.length();
        if (lenDiff < 0)
            return isOneEditDistance(t, s);
        if (lenDiff > 1) return false;
        char[] a = s.toCharArray(), b = t.toCharArray();
        for (int i = 0; i < b.length; i++)
            if (a[i] != b[i])
                if (lenDiff != 0)
                    return match(a, b, i + 1, i);
                else
                    return match(a, b, i + 1, i + 1);
        return lenDiff != 0;
    }

    boolean match(char[] s, char[] t, int i, int j) {
        while (i < s.length)
            if (s[i++] != t[j++])
                return false;
        return true;
    }
}