package repeated_substr_pattern;
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int len = 1; len <= s.length() / 2; len++)
            if (s.length() % len == 0) {
                String sub = s.substring(0, len);
                int i = len;
                for (; i < s.length(); i += len)
                    if (!s.substring(i, i + len).equals(sub))
                        break;
                if (i >= s.length()) return true;
            }
        return false;
    }
}
