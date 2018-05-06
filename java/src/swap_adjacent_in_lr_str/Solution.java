package swap_adjacent_in_lr_str;
public class Solution {
    public boolean canTransform(String start, String end) {
        char[] s1 = start.toCharArray(), s2 = end.toCharArray();
        for (int p1 = 0, p2 = 0; p1 < s1.length && p2 < s2.length; p1++, p2++) {
            while (p1 < s1.length && s1[p1] == 'X')
                p1++;
            while (p2 < s2.length && s2[p2] == 'X')
                p2++;
            if (p1 == s1.length && p2 == s2.length) return true;
            if (p1 == s1.length || p2 == s2.length || s1[p1] != s2[p2])
                return false;
            if (s1[p1] == 'L' && p2 > p1) return false;
            if (s1[p1] == 'R' && p1 > p2) return false;
        }
        return true;
    }
}
