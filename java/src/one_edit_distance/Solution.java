package one_edit_distance;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isOneEditDistance("a", ""));
    }

    public boolean isOneEditDistance(String s, String t) {//len(s) >= len(t)
        if (s.length() < t.length()) return isOneEditDistance(t, s);
        if (s.length() - t.length() > 1) return false;
        for (int i = 0; i < t.length(); i++)
            if (s.charAt(i) != t.charAt(i))
                if (s.length() == t.length())
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else
                    return s.substring(i + 1).equals(t.substring(i));
        return s.length() - t.length() == 1;
    }
}